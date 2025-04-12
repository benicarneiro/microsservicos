package com.example.springboot_dataset.repository;

import com.example.springboot_dataset.model.Alunos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunosRepository extends MongoRepository<Alunos, String> {
    List<Alunos> findByNomeContainingIgnoreCase(String nome);
    List<Alunos> findByCurso(String curso);
    List<Alunos> findByCoeficiente(Double min, Double max);
}
