package com.example.test004.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class GuhadaDatasource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseContextHolder.getDbType();
    }
}