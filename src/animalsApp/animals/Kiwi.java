/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalsApp.animals;

/**
 *
 * @author aldrai
 */
public class Kiwi extends Bird {

    public Kiwi(String name) {
        super(name);
    }

    @Override
    public void pose() {
        System.out.println("\t" + this.getName() + " is being adorable");
        fly();
    }
    
    public void fly() {
        System.out.println("\t" + this.getName() + " is flying around! (kiwis can fly, right?)");
    }
}
