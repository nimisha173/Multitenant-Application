package com.example.multitenantappln.service;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.HashMap;
import java.util.Map;

public class MasterService {
    public static Map<Object, Object> getDataSourceHashMap() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/multitenant1");
        dataSource.setUsername("root");
        dataSource.setPassword("pass@word1");
        DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setUrl("jdbc:mysql://localhost:3306/multitenant2");
        dataSource1.setUsername("root");
        dataSource1.setPassword("pass@word1");
        HashMap hashMap = new HashMap();
        hashMap.put("tenantId1", dataSource);
        hashMap.put("tenantId2", dataSource1);
        return hashMap;
    }
}
