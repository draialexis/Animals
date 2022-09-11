/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalsApp.animals;

/**
 *
 * @author aldrai
 */
public abstract class Animal {

    private String name;

    protected Animal(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("!!>> name cannot be null or blank");
        }
    }

    public abstract void pose();
    
    @Override
    public String toString() {
        return this.getName() + " the " + this.getClass().getSimpleName();
    }
}
