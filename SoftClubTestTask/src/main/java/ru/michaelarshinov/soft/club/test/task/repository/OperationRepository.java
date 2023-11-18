package ru.michaelarshinov.soft.club.test.task.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.michaelarshinov.soft.club.test.task.model.Operation;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Integer>{

}
