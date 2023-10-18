package org.example.repository;

import java.util.List;
import org.example.model.Factory;
public class FactoryInMemoryRepositoryImpl implements FactoryRepository {
    @Override
    public List<Factory> findAllFactory() {
        List<Factory> factoryList=
                List.of(
                        new Factory("KevinJeans",15,12,"indigo",10,1,"pantalones",500,12000),
        new Factory("Y&K",80,14,"crudo",80,2,"pantalones",5000,30000),
        new Factory("Montero",85,8,"liviana",50,2,"camisas",1200,50000),
        new Factory("Scuare",50,12,"indigo",60,3,"chaquetas",1500,10000),
        new Factory("ConfeccionesS.A",20,8,"indigo",15,2,"chores",1200,20000),
        new Factory("L&N",78,10,"indigo",60,2,"pantalones",12000,8000),
        new Factory("confesiones cochabamba",35,11,"indigo",2,8,"pantalones",5000,10000),
        new Factory("Gamin",60,10,"indigo",60,3,"pantalones",5000,50000),
        new Factory("Cosmos",45,12,"indigo",30,4,"pantalones",6000,15000),
        new Factory("El gato",65,12,"crudo",70,3,"pantalones",11000,20000),
        new Factory("Chevignon",30,12,"indigo",32,4,"chaquetas",8000,50000),
        new Factory("Lexus",8,7,"algodon",5,3,"camisas",500,25000),
        new Factory("Creaciones",28,14,"indigo",12,4,"pantalones",400,8000),
        new Factory("Muñetones",22,13,"indigo",18,2,"pantalones",10000,12000),
        new Factory("Confeciones",45,15,"indigo",40,3,"pantalones",1600,28000),
        new Factory("JeansB",34,15,"indigo",30,3,"pantalones",500,28000),
        new Factory("CDF",36,15,"indigo",36,3,"pantalones",1000,28000),
        new Factory("Prointex",24,15,"indigo",24,3,"pantalones",1300,28000),
        new Factory("Osmy Jeans",20,15,"indigo",20,3,"pantalones",1500,28000),
        new Factory("Confeccionees Berlin",15,15,"indigo",12,3,"pantalones",1100,28000)
        );

        return factoryList;
    }
}
