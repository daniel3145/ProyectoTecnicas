package org.example.controller;
import java.util.List;
import org.example.model.Factory;
import org.example.service.FactoryRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/factory/")
@CrossOrigin(origins = "*")
public class FactoryController {

    private final FactoryRecordService factoryRecordService;

   public FactoryController(FactoryRecordService factoryRecordService){this.factoryRecordService=factoryRecordService;}
    @GetMapping
    public List<Factory> factoryList()
    {


        return factoryRecordService.listAllFactory();

    }

    @PostMapping
    public ResponseEntity<Factory> addFactory(@RequestBody Factory newFactory)
    {

        Factory factory = factoryRecordService.addFactory(newFactory);
        return ResponseEntity.status(HttpStatus.OK).body( factory);
    }



}

