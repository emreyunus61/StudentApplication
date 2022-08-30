package com.example.studentapplication.repos;

import com.example.studentapplication.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Integer> {
}
