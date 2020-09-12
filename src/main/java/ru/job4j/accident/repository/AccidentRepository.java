package ru.job4j.accident.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.accident.model.Accident;

public interface AccidentRepository extends CrudRepository<Accident, Integer> {
//    @Override
//    public <S extends Accident> S save(S s) {
//        return null;
//    }
//
//    @Override
//    public <S extends Accident> Iterable<S> saveAll(Iterable<S> iterable) {
//        return null;
//    }
//
//    @Override
//    public Optional<Accident> findById(Integer integer) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Integer integer) {
//        return false;
//    }
//
//    @Override
//    public Iterable<Accident> findAll() {
//        return null;
//    }
//
//    @Override
//    public Iterable<Accident> findAllById(Iterable<Integer> iterable) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Integer integer) {
//
//    }
//
//    @Override
//    public void delete(Accident accident) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends Accident> iterable) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
}
