package pl.bykowski.springbootmongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalApi {

    private AnimalRepo animalRepo;

    @Autowired
    public AnimalApi(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        animalRepo.deleteAll();
        Animal animal1 = new Animal("Dog", 3);
        Animal animal2 = new Animal("Cat", 23);
        Animal animal3 = new Animal("Mouse", 1);
        Animal animal4 = new Animal("Bull", 4);
        animalRepo.save(animal1);
        animalRepo.save(animal2);
        animalRepo.save(animal3);
        animalRepo.save(animal4);
    }

    @GetMapping("/getAll")
    public List<Animal> get(@RequestParam int age) {
        return animalRepo.findByAgeGreaterThan(age);
    }



}
