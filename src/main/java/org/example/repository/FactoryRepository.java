package org.example.repository;

import java.util.List;
import org.example.model.Factory;
public interface FactoryRepository {
    List<Factory> findAllFactory();
}
