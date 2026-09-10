package com.assignment.traffic_backend.controller;

import com.assignment.traffic_backend.dto.TrafficSummaryResponse;
import com.assignment.traffic_backend.service.TrafficDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/traffic/summary")
@RequiredArgsConstructor
public class TrafficSummaryController {

    private final TrafficDataService trafficDataService;

    @GetMapping("/country")
    public List<TrafficSummaryResponse> getByCountry(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String vehicleType) {

        return trafficDataService.getTrafficByCountrySummary(year, vehicleType);
    }

    @GetMapping("/vehicle-type")
    public List<TrafficSummaryResponse> getByVehicleType(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String country) {

        return trafficDataService.getTrafficByVehicleTypeSummary(year, country);
    }
}