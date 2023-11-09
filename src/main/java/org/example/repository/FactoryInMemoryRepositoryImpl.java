package org.example.repository;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.example.model.Factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class FactoryInMemoryRepositoryImpl implements FactoryRepository {


    private static final Logger logger = LoggerFactory.getLogger(FactoryInMemoryRepositoryImpl.class);

    private List<Factory> factoryList;

    public FactoryInMemoryRepositoryImpl(){

        this.factoryList = new ArrayList<>(loadFactory());
    }

    private List<Factory> loadFactory() {
        logger.info("Cargando los datos predefinidos");
        List<String> plainTextFactoryList = readFileWithFactory();
        return plainTextFactoryList.stream().map(this::buildFactory).toList();
    }

    private List<String> readFileWithFactory()
    {
        logger.info("Leyendo el archivo");
        Path path = Paths.get("./src/main/resources/factory.txt");
        try(Stream<String> stream = Files.lines(path)){
            return stream.toList();
        }catch (IOException x)
        {
            logger.error("IOException: {0}",x);
        }
        return Collections.emptyList();
    }

    private Factory buildFactory(String plainTextFactory)
    {
       logger.info("Construyendo el vector");
       String[] questionArray = plainTextFactory.split(",");

       return new Factory(
         questionArray[0],
         Integer.valueOf(questionArray[1]),
         Integer.valueOf(questionArray[2]),
               questionArray[3],
               Integer.valueOf(questionArray[4]),
               Integer.valueOf(questionArray[5]),
               questionArray[6],
               Integer.valueOf(questionArray[7]),
               Integer.valueOf(questionArray[8])

       );
    }

    @Override
    public List<Factory> findAllFactory()
    {
        return factoryList;
    }


    private Predicate<Factory> isTheName(Factory newFactory)
    {
        return p ->p.Name().equals(newFactory.Name());
    }
}
