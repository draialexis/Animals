/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalsApp;

import animalsApp.animals.Kiwi;
import animalsApp.animals.Okapi;
import animalsApp.animals.Ostrich;
import animalsApp.animals.Animal;
import java.util.List;
import java.util.Scanner;

public class CLI {

    private final AnimalManager animalManager;
    private final Scanner scanner;

    public CLI() {
        this.animalManager = new AnimalManager();
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        boolean isQuitting = false;
        while (!isQuitting) {
            System.out.println();
            switch (requestLine("Menu"
                    + "\n0........to quit this program"
                    + "\n1........to register an animal"
                    + "\n2........to display all animals"
                    + "\n3........to modify an animal"
                    + "\n4........to delete an animal")) {
                case ("1") -> {
                    String name;
                    name = requestLine("enter name");
                    if (name != null) {
                        Animal newAnimal = null;
                        switch (requestLine("choose a species"
                                + "\n0........Okapi"
                                + "\n1........Ostrich"
                                + "\n2........Kiwi")) {
                            case ("0") -> {
                                newAnimal = new Okapi(name);
                            }
                            case ("1") -> {
                                newAnimal = new Ostrich(name);
                            }
                            case ("2") -> {
                                newAnimal = new Kiwi(name);
                            }
                            default -> {
                                System.out.println("not a valid option");
                                break;
                            }
                        }
                        if (newAnimal == null) { // should never be reached
                            break;              // should never be reached
                        }                       // should never be reached
                        registerAnimal(newAnimal);
                    }
                }
                case ("2") -> {
                    showAllAnimals();
                }
                case ("3") -> {
                    //...
                    modifyAnimal(String oldName, String newName);
                }
                case ("4") -> {
                    //...
                    deleteAnimal(String oldName);
                }
                case ("0") -> {
                    isQuitting = true;
                }
                default -> {
                    System.out.println("you must choose between 1 and 4, or quit with 0");
                }
            }
        }
    }

    private void registerAnimal(Animal newAnimal) {
        this.animalManager.createOne(newAnimal);
    }

    private void showAllAnimals() {
        List<Animal> displayed = this.animalManager.getAll();
        System.out.println("list of animals:");
        for (Animal animal : displayed) {
            System.out.println(animal);
        }
    }

    private void modifyAnimal(String oldName, String newName) {

    }

    private void deleteAnimal(String oldName) {

    }

    private String requestLine(String msg) {
        String input;
        System.out.println(msg);
        input = scanner.nextLine();
        return input;
    }
}
