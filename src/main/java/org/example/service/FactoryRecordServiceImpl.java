package org.example.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.example.model.Factory;
import org.example.repository.FactoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactoryRecordServiceImpl implements FactoryRecordService {

    private static final Logger logger = LoggerFactory.getLogger(FactoryRecordServiceImpl.class);
    private final FactoryRepository factoryRepository;

    public FactoryRecordServiceImpl(FactoryRepository factoryRepository) {
        this.factoryRepository = factoryRepository;
    }

    @Override
    public Integer calculateNumberPeople() {
        int quantity = 0;

        List<Factory> factoryList = this.factoryRepository.findAllFactory();
        for (Factory factory : factoryList) {
            quantity = quantity + factory.Nemployee();
        }
        System.out.println("Adding up number of Employees of all factories");
        logger.info("Adding employees ");
        logger.warn("Adding employees");
        logger.error("Adding employees");
        return quantity;
    }

    public String factoryNameEmployees() {
        String name = null;
        int nemployee = 0;

        List<Factory> factoryList = this.factoryRepository.findAllFactory();

        for (Factory factory : factoryList) {
            if (factory.Nemployee() > nemployee) {
                nemployee = factory.Nemployee();
                name = factory.Name();
            }
        }

        System.out.println("Looking for the name of the factory with the most employees");
        logger.info("Looking name factory");
        logger.warn("Looking name factory");
        logger.error("Looking name factory");

        return name;
    }

    @Override
    public BigDecimal averageMoney() {
        float accumulator = 0;
        List<Factory> factoryList = this.factoryRepository.findAllFactory();
        for (Factory factory : factoryList) {
            float value = factory.UnitValue() * factory.Nunit();
            accumulator += value;
        }
        BigDecimal average = BigDecimal.valueOf(accumulator / factoryList.size());
        System.out.println("Average money earned among all factories");
        logger.info("Average Money");
        logger.warn("Average Money");
        logger.error("Average Money");
        return average;
    }
    @Override
    public String mostEfficientName() {
        String name = null;
        List<Factory> factoryList = this.factoryRepository.findAllFactory();
        double minTime = Double.MAX_VALUE;


        for (Factory fabrica : factoryList) {
            double diasproduccion = (fabrica.CreationTimeU() * fabrica.Nunit()) / fabrica.HoursWorked();
            double tiempoPorUnidad = diasproduccion / fabrica.Nunit();
            if (tiempoPorUnidad < minTime) {
                minTime = tiempoPorUnidad;
                name = fabrica.Name();
            }
        }
        System.out.println("Looking for the name of the most efficient factory");
        logger.info("Looking most efficient");
        logger.warn("Looking most efficient");
        logger.error("Looking most efficient");
        return name;
    }

    @Override
    public Float medianNumberEmployees() {

        List<Factory> factoryList = this.factoryRepository.findAllFactory();
        int[] numEmployee = new int[factoryList.size()];
        for(int i = 0; i<factoryList.size();i++)
          {
            numEmployee[i] = factoryList.get(i).Nemployee();
          }


        Arrays.sort(numEmployee);


    float median;
        if(numEmployee.length %2==0)

    {

        int medium1 = numEmployee[numEmployee.length / 2 - 1];
        int medium2 = numEmployee[numEmployee.length / 2];
        median = (medium1 + medium2) / 2;
    } else

    {

        median = numEmployee[numEmployee.length / 2];
    }

        return median;
}


}
