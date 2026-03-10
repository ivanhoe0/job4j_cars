package ru.job4j.cars.repository.implementations;

import lombok.AllArgsConstructor;
import ru.job4j.cars.model.Car;
import ru.job4j.cars.repository.CarRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class HbmCarRepository implements CarRepository {
    private final CrudRepository crudRepository;

    @Override
    public Optional<Car> findById(int id) {
        return crudRepository.optional("FROM Car c WHERE c.id = :cid", Car.class, Map.of(":cid", id));
    }

    @Override
    public List<Car> findAll() {
        return crudRepository.query("FROM Car", Car.class);
    }
}
