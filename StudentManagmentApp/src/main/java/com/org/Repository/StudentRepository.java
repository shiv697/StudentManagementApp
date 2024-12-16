package com.org.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.model.Student;

@Repository
public interface StudentRepository  extends CrudRepository<Student, Integer>{
public List<Student> findAllByBatchNumber(String batchNumber);

}
