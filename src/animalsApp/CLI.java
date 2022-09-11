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

                // CREATE
                case ("1") -> {
                    try {
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
                                break;               // should never be reached
                            }                        // should never be reached
                            registerAnimal(newAnimal);
                        }
                    } catch (Exception e) {
                        System.out.println(e + " " + e.getMessage());
                        showMenu();
                        return;
                    }
                }

                // READ
                case ("2") -> {
                    showAllAnimals();
                }

                // UPDATE
                case ("3") -> {
                    try {
                        showAllAnimals();
                        modifyAnimal(
                                this.animalManager.getAll()
                                        .get(Integer.parseInt(
                                                requestLine("choose a number for which animal to update"))
                                        ),
                                requestLine("choose new name")
                        );
                    } catch (Exception e) {
                        System.out.println(e + " " + e.getMessage());
                        showMenu();
                        return;
                    }
                }

                // DELETE
                case ("4") -> {
                    try {
                        showAllAnimals();
                        deleteAnimal(this.animalManager.getAll()
                                .get(Integer.parseInt(
                                        requestLine("choose a number for which animal to delete"))
                                ));
                    } catch (Exception e) {
                        System.out.println(e + " " + e.getMessage());
                        showMenu();
                        return;
                    }
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

    private Animal registerAnimal(Animal newAnimal) {
        return this.animalManager.addOne(newAnimal);
    }

    private void showAllAnimals() {
        List<Animal> displayed = this.animalManager.getAll();
        System.out.println("list of animals:");
        int i = 0;
        for (Animal animal : displayed) {
            System.out.println(i + ": " + animal);
            animal.pose();
            i++;
        }
    }

    private Animal modifyAnimal(Animal oldAnimal, String newName) {
        return this.animalManager.updateOne(oldAnimal, newName);
    }

    private void deleteAnimal(Animal oldAnimal) {
        this.animalManager.deleteOne(oldAnimal);
    }

    private String requestLine(String msg) {
        String input;
        System.out.println(msg);
        input = scanner.nextLine();
        return input;
    }
}
