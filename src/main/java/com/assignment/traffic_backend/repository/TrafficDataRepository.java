package com.assignment.traffic_backend.repository;

import com.assignment.traffic_backend.dto.TrafficSummaryResponse;
import com.assignment.traffic_backend.entity.TrafficData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrafficDataRepository extends JpaRepository<TrafficData, Long> {

    @Query("""
                SELECT new com.assignment.traffic_backend.dto.TrafficSummaryResponse(
                    t.country,
                    SUM(t.trafficCount)
                )
                FROM TrafficData t
                WHERE (:year IS NULL OR t.year = :year)
                  AND (:vehicleType IS NULL OR t.vehicleType = :vehicleType)
                GROUP BY t.country
                ORDER BY SUM(t.trafficCount) DESC
            """)
    List<TrafficSummaryResponse> findTrafficByCountry(
            @Param("year") Integer year,
            @Param("vehicleType") String vehicleType
    );

    @Query("""
                SELECT new com.assignment.traffic_backend.dto.TrafficSummaryResponse(
                    t.vehicleType,
                    SUM(t.trafficCount)
                )
                FROM TrafficData t
                WHERE (:year IS NULL OR t.year = :year)
                  AND (:country IS NULL OR t.country = :country)
                GROUP BY t.vehicleType
                ORDER BY SUM(t.trafficCount) DESC
            """)
    List<TrafficSummaryResponse> findTrafficByVehicleType(
            @Param("year") Integer year,
            @Param("country") String country
    );
}
