/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._prog1;

/**
 * This class extention will hold attack options,
 * Including but not limited to; punch, kick, block...
 */
public class attack extends Fighter {
    // Placeholder for calling fighter constructor when initilizing class
    public Attack(String name, double health, double stamina) {
        super(name, health, stamina);
    }

    // Punch attack method
    public double punch() {
        double damage = 10.0;
        double staminaCost = 5.0;
    }

    // Kick attack method
    public double kick() {
        double damage = 15.0;
        double staminaCost = 7.0;
    }

    // Additional attack options like grappling, blocking, etc., can be added here.
}
    
}
