/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animals;

/**
 *
 * @author aldrai
 */
public abstract class Animal {
    private String name;
    
    protected Animal(String name){
        this.name = name;
    }
    
    public void getName(){
        System.out.println(this.name);
    }
}
