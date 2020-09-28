package org.two.data.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.two.data.source.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
