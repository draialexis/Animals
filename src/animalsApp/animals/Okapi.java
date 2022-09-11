/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalsApp.animals;

/**
 *
 * @author aldrai
 */
public class Okapi extends Animal {

    public Okapi(String name) {
        super(name);
    }

    @Override
    public void pose() {
        System.out.println("\t" + this.getName() + " is standing on four legs");
    }
}
