package org.example.service;

import java.math.BigDecimal;

import org.example.exception.FactoryNotFoundException;
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
        logger.info("Calculando el promedio de calificacioens");
       // List<Factory> factoryList = this.factoryRepository.findAllFactory();
        List<Factory> factoryList = this.factoryRepository.findAllFactory();
        for (Factory factory : factoryList) {
            quantity = quantity + factory.Nemployee();
        }

        return quantity;
    }

    public String factoryNameEmployees() {
        String name = null;
        int nemployee = 0;
        logger.info("Mostrando el nombre de la fabrica con mas empleados");
        List<Factory> factoryList = this.factoryRepository.findAllFactory();

        for (Factory factory : factoryList) {
            if (factory.Nemployee() > nemployee) {
                nemployee = factory.Nemployee();
                name = factory.Name();
            }
        }
        return name;
    }

    @Override
    public BigDecimal averageMoney() {
        float accumulator = 0;
        logger.info("Calculando el promedio de dinero de todas las fabricas");
        List<Factory> factoryList = this.factoryRepository.findAllFactory();
        for (Factory factory : factoryList) {
            float value = factory.UnitValue() * factory.Nunit();
            accumulator += value;
        }
        BigDecimal average = BigDecimal.valueOf(accumulator / factoryList.size());

        return average;
    }

    @Override
    public String mostEfficientName() {
        String name = null;
        logger.info("Buscando la fabrica mas eficiente");
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
        return name;
    }

    @Override
    public Float medianNumberEmployees() {
        logger.info("Media de Empleados de las fabricas");
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
