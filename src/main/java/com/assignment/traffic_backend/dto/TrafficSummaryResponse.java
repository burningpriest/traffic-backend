package com.assignment.traffic_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrafficSummaryResponse {
    private String category;
    private Long total;
}
