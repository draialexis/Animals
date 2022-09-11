/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalsApp.animals;

/**
 *
 * @author aldrai
 */
public abstract class Bird extends Animal {

    private final int numberOfWings = 2;

    protected Bird(String name) {
        super(name);
    }

    public int getNumberOfWings() {
        return numberOfWings;
    }

    @Override
    public String toString() {
        return this.getName() + " the " + this.getClass().getSimpleName() + ", owns " + this.getNumberOfWings() + " wings";
    }   
}
