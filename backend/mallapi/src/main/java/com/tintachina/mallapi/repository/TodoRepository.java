package com.tintachina.mallapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tintachina.mallapi.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
    
}
