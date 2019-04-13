package pl.bykowski.springbootmongodb;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepo extends MongoRepository<Animal, String> {

    List<Animal> findByAgeGreaterThan(int age);
}
