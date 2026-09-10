package com.assignment.traffic_backend.service;

import com.assignment.traffic_backend.dto.TrafficSummaryResponse;
import com.assignment.traffic_backend.repository.TrafficDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TrafficDataService {

    private final TrafficDataRepository trafficDataRepository;

    public List<TrafficSummaryResponse> getTrafficByCountrySummary(
            Integer year,
            String vehicleType) {

        return trafficDataRepository.findTrafficByCountry(
                year,
                vehicleType
        );
    }

    public List<TrafficSummaryResponse> getTrafficByVehicleTypeSummary(
            Integer year,
            String country) {

        return trafficDataRepository.findTrafficByVehicleType(
                year,
                country
        );
    }
}