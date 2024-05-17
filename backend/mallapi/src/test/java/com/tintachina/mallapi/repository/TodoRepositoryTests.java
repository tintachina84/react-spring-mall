package com.tintachina.mallapi.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tintachina.mallapi.domain.Todo;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class TodoRepositoryTests {
    
    @Autowired
    private TodoRepository todoRepository;

    // @Test
    public void testInsert() {
        for (int i = 1; i <= 100; i++) {
            Todo todo = Todo.builder()
            .title("Test..." + i)
            .dueDate(LocalDate.of(2023, 12, 31))
            .writer("user00")
            .build();


            this.todoRepository.save(todo);
        }
    }

    @Test
    public void testRead() {
        Long tno = 33L;
        Optional<Todo> result = this.todoRepository.findById(tno);
        Todo todo = result.orElseThrow();
        log.info(todo.toString());
    }

    @Test
    public void testModify() {
        Long tno = 33L;
        Optional<Todo> result = this.todoRepository.findById(tno);
        Todo todo = result.orElseThrow();

        todo.changeTitle("Changed Title...");
        todo.changeCompleted(true);
        todo.changeDueDate(LocalDate.of(2023, 10, 10));

        this.todoRepository.save(todo);
    }

    @Test
    public void testDelete() {
        Long tno = 1L;
        this.todoRepository.deleteById(tno);
    }
}
