package ru.job4j.cars.repository.implementations;

import lombok.AllArgsConstructor;
import ru.job4j.cars.model.Engine;
import ru.job4j.cars.repository.EngineRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class HbmEngineRepository implements EngineRepository {
    private final CrudRepository crudRepository;

    @Override
    public Optional<Engine> findById(int id) {
        return crudRepository.optional("FROM Engine WHERE id = :eid", Engine.class, Map.of("eid", id));
    }

    @Override
    public List<Engine> findAll() {
        return crudRepository.query("FROM Engine", Engine.class);
    }
}
