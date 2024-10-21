e/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._prog1;

/**
 * Battle
 * All_Attacks: Creates the attacks and defense choices  [This will create the each possible attack]
 * Attributes: This gives each fighter their values for damages and defensive stats 
 * Players_Choices: This can be different attack options or defending options based on the decision 
 * [This will use All_Attacks, but will be just the available attacks for each fighter]
 *that the player/AI chooses.
 */
public class Fighter {
    //Attributes
    private string fighterName="";
    private int countryOfOrigin=0;
    private int hp=100;
    private int energy=100;
    private int fitness=0;
    private int recovery=0;
    private int attack=0;
    private int defense=0;
    private int speed=0;
    private int block=0;
    private int grapple=0;
    //Invisible Stats
    private int grappleResistance=0;
    private int dodge =0;
    private int strongAttack=0;
    ////Constructers
    //Base Constructer
    public Fighter()
    {

    }
    //Parameterized Constructers
    public Fighter()
    {

    }


    // Placeholder method to update health when damage is taken
    public void update(double damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }
}
