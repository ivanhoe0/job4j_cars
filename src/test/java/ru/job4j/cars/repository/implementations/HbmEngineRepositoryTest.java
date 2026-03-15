package ru.job4j.cars.repository.implementations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.cars.model.Engine;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HbmEngineRepositoryTest {
    private static HbmEngineRepository repository;

    @BeforeAll
    public static void initConnections() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        SessionFactory sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory();
        CrudRepository crudRepository = new CrudRepository(sf);
        repository = new HbmEngineRepository(crudRepository);
    }

    @Test
    void WhenAddEngineThenReturnTheSame() {
        var engine = new Engine();
        engine.setId(1);
        engine.setName("Test Engine");
        repository.save(engine);
        var savedEngine = repository.findById(engine.getId()).get();
        assertThat(savedEngine).usingRecursiveAssertion().isEqualTo(engine);
    }
}