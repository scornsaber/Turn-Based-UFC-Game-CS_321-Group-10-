/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._prog1;

/**
 * Battle
 * Fight Choice: Intiate one of the choices from the fighter class that is 
 *attack/defense
 */
public class Battle {
    private Fighter fighter1;
    private Fighter fightet2;

    // Constructer
    public Battle(Fighter fighter1, Fighter fighter2) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
        
    }
    public void BeginBattle(){
        System.out.println("Battle begin message");
        boolean battleOngoing = true;

        //Loop body is just a for instance/place holder
        while (battleOngoing) {
            double damageDealt = fighter1.punch();
            fighter2.update(damageDealt);
            System.out.println(fighter1.getName() + " attacks " + fighter2.getName() + " dealing " + damageDealt + " damage!");
        }

            if (fighter2.getHealth() <= 0) {
                System.out.println(fighter1.getName() + " wins the battle!");
                battleOngoing = false;
                break;
            }

            // Fighter 2 attacks Fighter 1
            double damageDealt = fighter2.kick();
            fighter1.update(damageDealt);
            System.out.println(fighter2.getName() + " attacks " + fighter1.getName() + " dealing " + damageDealt + " damage!");
            System.out.println(fighter1.getName() + "'s health: " + fighter1.getHealth());

            if (fighter1.getHealth() <= 0) {
                System.out.println(fighter2.getName() + " wins the battle!");
                battleOngoing = false;
            }
            
    }
}
