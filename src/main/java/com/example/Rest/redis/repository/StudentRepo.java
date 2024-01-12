package com.example.Rest.redis.repository;

import com.example.Rest.redis.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, String> {
}
