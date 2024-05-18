package ru.netology.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.netology.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
