package com.ATDevServiceTask.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ATDevServiceTask.model.Student;

@Repository
public interface StudentRepo extends  JpaRepository<Student, Integer>  {

}
