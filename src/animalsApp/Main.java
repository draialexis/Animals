/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package animalsApp;

import java.util.Scanner;

/**
 *
 * @author aldrai
 */
public class Main {

    private final static AnimalManager manager = new AnimalManager();
    private final static Scanner scanner = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CLI cli = new CLI(manager, scanner);

        cli.showMenu();
    }

}
