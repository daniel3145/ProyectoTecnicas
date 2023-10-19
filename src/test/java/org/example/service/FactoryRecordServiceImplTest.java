package org.example.service;

import static org.junit.jupiter.api.Assertions.*;

import org.example.repository.FactoryInMemoryRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class FactoryRecordServiceImplTest {

    private FactoryRecordService factoryRecordService;

    @BeforeEach
    void setUp()
    {
        this.factoryRecordService = new FactoryRecordServiceImpl(new FactoryInMemoryRepositoryImpl());
    }

    @Test
    void Calcular_cantidad_de_personas(){
        Integer cantidad = this.factoryRecordService.calculateNumberPeople();

        assertNotNull(cantidad);
        assertEquals(795,cantidad);

    }
    @Test
    void Buscando_nombre_fabrica_mas_empleados(){
        String nombre=this.factoryRecordService.factoryNameEmployees();
        assertNotNull(nombre);
        assertEquals("Montero",nombre);

    }
}
