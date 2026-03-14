package ru.job4j.cars.repository.implementations;

import lombok.AllArgsConstructor;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class HbmPostRepository implements PostRepository {
    private final CrudRepository crudRepository;

    @Override
    public List<Post> findByBrand(String name) {
        return crudRepository.query("FROM Post p JOIN FETCH Car c WHERE c.name = :pname", Post.class, Map.of("pname", name));
    }

    @Override
    public List<Post> findLastDayPosts() {
        LocalDateTime twentyFourHoursAgo = LocalDateTime.now().minusHours(24);
        return crudRepository.query("FROM Post p WHERE p.created <= :pdate", Post.class, Map.of("pdate", twentyFourHoursAgo));
    }

    @Override
    public List<Post> findPostWithPhoto() {
        return crudRepository.query("FROM Post p JOIN FETCH p.files", Post.class);
    }
}
