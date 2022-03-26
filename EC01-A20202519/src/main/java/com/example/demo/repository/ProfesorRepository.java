package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Profesor;
@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer>{

}
