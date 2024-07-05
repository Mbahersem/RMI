package com.example.demo.entity;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table(value = "data_by_token")
public class DataByToken {
    @PrimaryKeyColumn(name = "api", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String api;
    @PrimaryKeyColumn(name = "deviceid", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private UUID deviceId;
    private Date date;
    private int n;
    private  int p;
    private int k;
    private int ph;
    private int h;
    private int t;
    private String soilType;
}
