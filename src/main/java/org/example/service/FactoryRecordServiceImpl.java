package org.example.service;

import java.math.BigDecimal;
import java.util.List;
import org.example.model.Factory;
import org.example.repository.FactoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactoryRecordServiceImpl implements FactoryRecordService {

    private static final Logger logger = LoggerFactory.getLogger(FactoryRecordServiceImpl.class);
    private final FactoryRepository factoryRepository;

    public FactoryRecordServiceImpl(FactoryRepository factoryRepository){
        this.factoryRepository = factoryRepository;
    }

    @Override
    public Integer calcularCantidadPersonas(){
        int cantidad=0;

    List<Factory> factoryList = this.factoryRepository.findAllFactory();
        for (Factory factory : factoryList) {
            cantidad = cantidad + factory.NOperarios();
        }
            System.out.println("Sumando el número de empleados");
            logger.info("Sumando el número de empleados");
            logger.warn("Sumando el número de empleados");
            logger.error("Sumando el número de empleados");
        return cantidad;
    }

    public String NombreMasEmpleados()
    {
        String Nombre=null;
        int nempleados=0;

        List<Factory> factoryList = this.factoryRepository.findAllFactory();

        for (Factory factory : factoryList) {
            if (factory.NOperarios() > nempleados) {
                nempleados = factory.NOperarios();
                Nombre = factory.NombreFabrica();
            }
        }

        System.out.println("Buscando el nombre de la fabrica mas empleados");
        logger.info("Buscando Numero de Empleados");
        logger.warn("Buscando Numero de Empleados");
        logger.error("Buscando Numero de Empleados");

        return Nombre;
    }

    @Override
    public BigDecimal PromedioDinero() {
        float Acumulador=0;
        List<Factory> factoryList=this.factoryRepository.findAllFactory();
            for(Factory factory: factoryList){
                float valor = factory.ValorUnidad() * factory.Nunidades();
                Acumulador += valor;
            }
        BigDecimal promedio = BigDecimal.valueOf(Acumulador / factoryList.size());
        System.out.println("Promedio de dimero ganado");
        logger.info("Promedio de dinero");
        logger.warn("Promedio de dinero");
        logger.error("Promedio de dinero");
        return promedio;
    }

    public String FabricaMasEficiente()
    {
        String nombre=null;
        List<Factory> factoryList=this.factoryRepository.findAllFactory();
        double minTiempoPorUnidad = Double.MAX_VALUE;
        String fabricaMinTiempo = "";


        for (Factory fabrica : factoryList) {
            double diasproduccion=(fabrica.TiempoCreacionTotalU()* fabrica.Nunidades())/fabrica.HorasTrabajadas();
            double tiempoPorUnidad = diasproduccion / fabrica.Nunidades();
            if (tiempoPorUnidad < minTiempoPorUnidad) {
                minTiempoPorUnidad = tiempoPorUnidad;
                nombre = fabrica.NombreFabrica();
            }
        }
        System.out.println("Buscando fabrica mas eficiente");
        logger.info("Buscando mas eficiente");
        logger.warn("Buscando mas eficiente");
        logger.error("Buscando mas eficiente");
        return nombre;
    }
}
