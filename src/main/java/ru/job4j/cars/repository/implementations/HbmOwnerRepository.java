package ru.job4j.cars.repository.implementations;

import lombok.AllArgsConstructor;
import ru.job4j.cars.model.Owner;
import ru.job4j.cars.repository.OwnerRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class HbmOwnerRepository implements OwnerRepository {
    private final CrudRepository crudRepository;

    @Override
    public Optional<Owner> findById(int id) {
        return crudRepository.optional("FROM Owner WHERE id = :oid", Owner.class, Map.of("oid", id));
    }

    @Override
    public List<Owner> findAll() {
        return crudRepository.query("FROM Owner", Owner.class);
    }
}
