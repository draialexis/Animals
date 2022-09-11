package animalsApp;

import animalsApp.animals.Animal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnimalManager {

    private final List<Animal> animals;

    public AnimalManager() {
        this.animals = new ArrayList<>();
    }

    /**
     * Get all animals from the list
     *
     * @return an unmodifiable view of the list of all animals
     */
    public List<Animal> getAll() {
        return Collections.unmodifiableList(this.animals);
    }

    public Animal getOne(String name, String type) {

    }

    public void createOne(Animal newAnimal) {
        this.animals.add(newAnimal);
    }
}
