package animalsApp;

import animalsApp.animals.Animal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    private Animal getOne(String name, String type) {
        // try to find that unique combo
        List<Animal> candidates = this.animals
                .stream()
                .filter(animal -> animal.getClass().getSimpleName().equalsIgnoreCase(type)
                && animal.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        if (!candidates.isEmpty()) {
            // found one (should only be one)
            return candidates.get(0);
        } else {
            return null;
        }
    }

    public Animal addOne(Animal newAnimal) throws IllegalArgumentException {
        if (newAnimal == null) {
            throw new IllegalArgumentException(
                    "!!>> new Animal may not be null"
            );
        }
        // if violates the unique combo, throw
        if (getOne(newAnimal.getName(), newAnimal.getClass().getSimpleName()) != null) {
            throw new IllegalArgumentException(
                    "!!>> you cannot name two " + newAnimal.getClass().getSimpleName()
                    + " " + newAnimal.getName()
            );
        }
        this.animals.add(newAnimal);
        return newAnimal;
    }

    public Animal updateOne(Animal oldAnimal, String newName) throws IllegalArgumentException {
        if (oldAnimal == null) {
            throw new IllegalArgumentException(
                    "!!>> oldAnimal may not be null"
            );
        }
        // if violates the unique combo, throw
        if (getOne(newName, oldAnimal.getClass().getSimpleName()) != null) {
            throw new IllegalArgumentException(
                    "!!>> you cannot name two " + oldAnimal.getClass().getSimpleName()
                    + " " + newName
            );
        }
        oldAnimal.setName(newName);
        return oldAnimal;
    }

    public void deleteOne(Animal oldAnimal) throws IllegalArgumentException {
        if (oldAnimal == null) {
            throw new IllegalArgumentException(
                    "!!>> oldAnimal may not be null"
            );
        }
        this.animals.remove(oldAnimal);
    }
}
