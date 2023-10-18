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
                        "Cantidad de Personas :{0}", factoryRecordService.calcularCantidadPersonas()));
        System.out.println(
                MessageFormat.format(
                        "La fabrica con mayor numero de empleados es :{0}", factoryRecordService.NombreMasEmpleados()));
        System.out.println(
                MessageFormat.format(
                        "El Promedio de Dinero de fabricas es es :{0}$", factoryRecordService.PromedioDinero()));
        System.out.println(
                MessageFormat.format(
                        "La fabrica mas eficiente :{0}", factoryRecordService.FabricaMasEficiente()));


    }

}