package com.example.springboot_dataset.controller;

import com.example.springboot_dataset.model.Alunos;
import com.example.springboot_dataset.service.AlunosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    @Autowired
    private AlunosService alunosService;

    @GetMapping
    public List<Alunos> getAllItems(){
        return alunosService.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alunos> getItemById(@PathVariable String id){
        return alunosService.getItemById(id);
    }
    
    @GetMapping("/by-name")
    public ResponseEntity<List<Alunos>> getItemByName(@RequestParam String name){
        return alunosService.findByNomeContainingIgnoreCase(name);
    }

    @GetMapping("/by-category")
    public ResponseEntity<List<Alunos>> getItemByCategory(@RequestParam String category){
        return alunosService.findByCurso(category);
    }

    @GetMapping("by-coeficient")
    public ResponseEntity<List<Alunos>> getByCoeficiente(@RequestParam Double min, @RequestParam Double max){
        return alunosService.findByCoeficiente(min, max);
    }

    @PostMapping
    public Alunos createItem(@RequestBody Alunos alunos){
        return alunosService.createItem(alunos);
    }
}
