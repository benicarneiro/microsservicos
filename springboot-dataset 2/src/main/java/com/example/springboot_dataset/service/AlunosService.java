package com.example.springboot_dataset.service;

import com.example.springboot_dataset.model.Alunos;
import com.example.springboot_dataset.repository.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunosService {

    @Autowired
    private AlunosRepository alunosRepository;

    public List<Alunos> getAllItems(){
        return alunosRepository.findAll();
    }

    public ResponseEntity<Alunos> getItemById(String id){
        return alunosRepository.findById(id)
                .map(ResponseEntity :: ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Alunos>> findByNomeContainingIgnoreCase(String name){
        List<Alunos> alunos = alunosRepository.findByNomeContainingIgnoreCase(name);
        return ResponseEntity.ok(alunos);
    }

    public ResponseEntity<List<Alunos>> findByCurso(String category){
        List<Alunos> alunos = alunosRepository.findByCurso(category);
        return ResponseEntity.ok(alunos);
    }

    public ResponseEntity<List<Alunos>> findByCoeficiente(Double min, Double max){
        List<Alunos> alunos = alunosRepository.findByCoeficiente(min, max);
        return ResponseEntity.ok(alunos);
    }

    public Alunos createItem(Alunos alunos){
        return alunosRepository.save(alunos);
    }
}
