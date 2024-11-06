/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._prog1;

/**
 * Battle
 * Fight Choice: Intiate one of the choices from the fighter class that is 
 * attack/defense
 */
public class Battle {
    private Fighter fighter1;
    private Fighter fighter2;
    private Arena location;

    // Constructor
    public Battle(Fighter fighter1, Fighter fighter2, Arena arena) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
        this.location = arena;
    }
    public void DoBattle(){                           // Changed name from BeginBattle() to DoBattle
        double fighter1Speed = 0.0; // Speed values are determined each turn depending on user stats & attack choice
        double fighter2Speed = 0.0;
        Attack fighter1Attack = Attack(); // Default initialization value.
        Attack fighter2Attack = Attack();
        Limb fighter1Limb;
        Limb fighter2Limb;

        Fighter* faster = null;
        Fighter* slower = null;
        System.out.println("Battle begin message");
        boolean battleOngoing = true;                              

        //Loop body is just a for instance/place holder
        while (battleOngoing) {
            // First, get each Fighter's attack choice. This will be handled in GUI.
            fighter1Attack = fighter1.GetAttackChoice(fighter1Attack, fighter1Limb);
            fighter2Attack = fighter2.GetAttackChoice(fighter2Attack, fighter2Limb);

            // Calculate each Fighter's speed this turn.
            fighter1Speed = fighter1.GetAttackSpeed(fighter1Attack, fighter1Limb)
            fighter2Speed = fighter1.GetAttackSpeed(fighter2Attack, fighter2Limb)

            // Designate faster and slower fighter for THIS TURN ONLY.
            if (fighter1Speed > fighter2Speed)
            {
              *faster = fighter1;
              *slower = fighter2;
            }
            else if (fighter2Speed > fighter1Speed)
            {
              *faster = fighter2;
              *slower = fighter1;
            }
            else // Speed tie this turn.
            {
              // This will eventually be implemented as a random function to choose between the two.
              // For now it will just choose fighter1.
              *faster = fighter1;
              *slower = fighter2;
            }
          
            // Calculate damage values.

            // Deal damage to slower fighter.
            //*slower.DealDamage(*faster.GetAttackDamage(fighter1Attack,*slower,))

            double damageDealt = fighter1.punch();
            fighter2.update(damageDealt);
            System.out.println(fighter1.GetName() + " attacks " + fighter2.GetName() + " dealing " + damageDealt + " damage!");
        }

            if (fighter2.getHealth() <= 0) {
                System.out.println(fighter1.GetName() + " wins the battle!");
                battleOngoing = false;
                break;
            }

            // Fighter 2 attacks Fighter 1
            double damageDealt = fighter2.kick();
            fighter1.update(damageDealt);
            System.out.println(fighter2.GetName() + " attacks " + fighter1.getName() + " dealing " + damageDealt + " damage!");
            System.out.println(fighter1.getName() + "'s health: " + fighter1.getHealth());

            if (fighter1.getHealth() <= 0) {
                System.out.println(fighter2.getName() + " wins the battle!");
                battleOngoing = false;
            }
            
    }
}
