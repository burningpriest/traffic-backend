package com.assignment.traffic_backend.service;

import com.assignment.traffic_backend.dto.TrafficSummaryResponse;
import com.assignment.traffic_backend.repository.TrafficDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class TrafficDataService {

    private final TrafficDataRepository trafficDataRepository;

    public List<TrafficSummaryResponse> getTrafficByCountrySummary(
            Integer year,
            String vehicleType) {

        long startTime = System.currentTimeMillis();

        log.info("Fetching traffic summary by country. year={}, vehicleType={}",
                year, vehicleType);

        List<TrafficSummaryResponse> result =
                trafficDataRepository.findTrafficByCountry(year, vehicleType);

        log.info("Traffic summary by country completed. year={}, vehicleType={}, results={}, durationMs={}",
                year,
                vehicleType,
                result.size(),
                System.currentTimeMillis() - startTime);

        return result;
    }

    public List<TrafficSummaryResponse> getTrafficByVehicleTypeSummary(
            Integer year,
            String country) {

        long startTime = System.currentTimeMillis();

        log.info("Fetching traffic summary by vehicle type. year={}, country={}",
                year, country);

        List<TrafficSummaryResponse> result =
                trafficDataRepository.findTrafficByVehicleType(year, country);

        log.info("Traffic summary by vehicle type completed. year={}, country={}, results={}, durationMs={}",
                year,
                country,
                result.size(),
                System.currentTimeMillis() - startTime);

        return result;
    }
}