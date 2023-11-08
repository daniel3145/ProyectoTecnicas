package org.example;

import java.text.MessageFormat;
import org.example.repository.FactoryInMemoryRepositoryImpl;
import org.example.service.FactoryRecordService;
import org.example.service.FactoryRecordServiceImpl;

public class ApplicationRunner{
    public static void main(String[] args)
    {
        FactoryRecordService factoryRecordService = new FactoryRecordServiceImpl(new FactoryInMemoryRepositoryImpl());

        System.out.println(
                MessageFormat.format(
                        "Number of Employees in the factorie :{0}", factoryRecordService.calculateNumberPeople()));
        System.out.println(
                MessageFormat.format(
                        "Factory with the highest number of employees :{0}", factoryRecordService.factoryNameEmployees()));
        System.out.println(
                MessageFormat.format(
                        "Average amount of money :{0}$", factoryRecordService.averageMoney()));
        System.out.println(
                MessageFormat.format(
                        "Most efficient factory :{0}", factoryRecordService.mostEfficientName()));

        System.out.println(
                MessageFormat.format(
                        "Median number of employees of factories :{0}", factoryRecordService.medianNumberEmployees()));

    }

}