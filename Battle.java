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
public class Battle
{
  private Fighter fighter1;
  private Fighter fighter2;
  private Arena location;

  // Constructor
  public Battle(Fighter fighter1, Fighter fighter2, Arena arena)
  {
    this.fighter1 = fighter1;
    this.fighter2 = fighter2;
    this.location = arena;
  }


  // NOTE: Need to add null ptr checks later!!
  // ALSO: Check to be sure pointer referencing and dereferencing was done correctly.
  public void DoBattle()              // Changed name from BeginBattle() to DoBattle
  {               
    double fighter1Speed = 0.0;       // Speed values are determined each turn depending on user stats & attack choice
    double fighter2Speed = 0.0;
    Attack fighter1Attack = Attack(); // Default initialization value.
    Attack fighter2Attack = Attack();
    Limb fighter1Limb;
    Limb fighter2Limb;

    Fighter* fasterFighter = null;    // Recalculated each turn.
    Fighter* slowerFighter = null;

    Fighter* winner = null;
    Fighter* loser = null;
    System.out.println("Battle begin message");
    boolean battleOngoing = true;                              

    //Loop body is just a for instance/place holder
    while (battleOngoing) {
      // First, get each Fighter's attack choice. This will be handled in GUI.
      fighter1.ChooseAttack();
      fighter2.ChooseAttack();

      // Calculate each Fighter's speed this turn.
      fighter1Speed = fighter1.GetCurrentAttackSpeed();
      fighter2Speed = fighter1.GetCurrentAttackSpeed();

      // Designate faster and slower fighter for THIS TURN ONLY.
      if (fighter1Speed > fighter2Speed)
      {
        fasterFighter = fighter1;
        slowerFighter = fighter2;
      }
      else if (fighter2Speed > fighter1Speed)
      {
        fasterFighter = fighter2;
        slowerFighter = fighter1;
      }
      else // Speed tie this turn.
      {
        // This will eventually be implemented as a random function to choose between the two.
        // For now it will just choose fighter1.
        fasterFighter = fighter1;
        slowerFighter = fighter2;
      }
      
      // Calculate damage values.
      int fasterAttackDamage = *fasterFighter.GetCurrentAttackDamage(*slowerFighter); // *slowerFighter is the attack TARGET.
      int slowerAttackDamage = *slowerFighter.GetCurrentAttackDamage(*fasterFighter);
        
      // Deal damage to slower fighter.
      *slowerFighter.DealDamage(fasterAttackDamage);
      System.out.println(*fasterFighter.GetName() + " attacks " + *slowerFighter.GetName() + " dealing " + fasterAttackDamage + " damage.");
      // Check for KO on slower fighter.
      if (*slowerFighter.GetHP() <= 0)
      {
        winner = fasterFighter;
        loser = slowerFighter;
        battleOngoing = false;
      }
      else
      {
        // Deal damage to faster fighter.
        *fasterFighter.DealDamage(slowerAttackDamage);
        System.out.println(*slowerFighter.GetName() + " attacks " + *fasterFighter.GetName() + " dealing " + slowerAttackDamage + " damage.");
        // Check for KO on faster fighter.
        if (*fasterFighter.GetHP() <= 0)
        {
          winner = slowerFighter;
          loser = fasterFighter;
          battleOngoing = false;
        }
      }
    } // End of while(battleOngoing) loop.   

    // Declare winner and loser.
    System.out.println(*loser.GetName() + " was knocked out!");
    System.out.println(*winner.GetName() + " wins!");

    // Restore Fighters' HP and Energy.
    fighter1.Restore();
    fighter2.Restore();
  } // End of DoBattle()
}
