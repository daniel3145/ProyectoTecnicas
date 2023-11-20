package org.example.service;



import java.util.List;
import org.example.model.Factory;


import java.math.BigDecimal;

public interface FactoryRecordService {

    Integer calculateNumberPeople();
    String factoryNameEmployees();
    BigDecimal averageMoney();
    String mostEfficientName();
    Float medianNumberEmployees();

    List <Factory> listAllFactory();

    Factory addFactory(Factory newFactory);

}
