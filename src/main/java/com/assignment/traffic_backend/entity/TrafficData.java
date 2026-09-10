package com.assignment.traffic_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "traffic_data")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrafficData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "year")
    private Integer year;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "traffic_count")
    private Long trafficCount;
}
