/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animals;

import java.util.List;
import java.util.Scanner;

public class Displayer {

    private final AnimalManager animalManager;
    private final Scanner scanner;

    public Displayer() {
        this.animalManager = new AnimalManager();
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        boolean isQuitting = false;
        while (!isQuitting) {
            int choice;
            System.out.println("0........to quit this program");
            System.out.println("1........to register an animal");
            System.out.println("2........to display all animals");
            System.out.println("3........to modify an animal");
            System.out.println("4........to delete an animal");
            choice = scanner.nextInt();
            switch (choice) {
                case (1) -> {
                    int species;
                    String name;
                    
                    System.out.println("choose a species");
                    System.out.println("0........Okapi");
                    System.out.println("1........FlyingFrog");
                    System.out.println("2........DemonSquid");
                    System.out.println("3........Ostrich");
                    System.out.println("4........Kiwi");
                    species = scanner.nextInt();
                    
                    System.out.println("enter name (no spaces allowed)");
                    name = scanner.next();
                    scanner.nextLine();
                    if (name != null && species >= 0 && species <= 4) {
                        Animal newAnimal;
                        switch (species) {
                            case (0) -> {
                                newAnimal = new Okapi(name);
                            }
                            case (1) -> {
                                newAnimal = new FlyingFrog(name);
                            }
                            case (2) -> {
                                newAnimal = new DemonSquid(name);
                            }
                            case (3) -> {
                                newAnimal = new Ostrich(name);
                            }
                            case (4) -> {
                                newAnimal = new Kiwi(name);
                            }
                        }
                        registerAnimal(newAnimal);
                    }
                }
                case (2) -> {
                    showAllAnimals();
                }
                case (3) -> {
                    modifyAnimal();
                }
                case (4) -> {
                    deleteAnimal();
                }
                case (0) -> {
                    isQuitting = true;
                }
                default -> {
                    System.out.println("you must choose between 1 and 4, or quit with 0");
                }
            }
        }
    }

    private void showAllAnimals() {
        List<Animal> displayed = this.animalManager.getAll();
        System.out.println("list of animals:");
        for (Animal animal : displayed) {
            System.out.println(animal);
        }
    }

    private void registerPatient(Animal newAnimal) {
        this.animalManager.createOne(newAnimal);
    }
}
