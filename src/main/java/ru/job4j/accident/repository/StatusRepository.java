package ru.job4j.accident.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.accident.model.Status;

public interface StatusRepository extends CrudRepository<Status, Integer> {
}
