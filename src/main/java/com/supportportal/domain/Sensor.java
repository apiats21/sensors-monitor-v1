package com.supportportal.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "sensor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 30)
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Column(name = "model", length = 30)
    @NotEmpty(message = "Model cannot be empty")
    private String model;

    private Long rangeFrom;

    private Long rangeTo;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 30)
    private Type type;

    @Enumerated(EnumType.STRING)
    @Column(name = "unit", length = 30)
    private Unit unit;

    @Column(name = "location", length = 40)
    private String location;

    @Column(name = "description", length = 200)
    private String description;
}

