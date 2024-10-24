/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._prog1;

// Class storing attributes for Fighters' attack choices.
// All damage calculation will be handled in Fighter using the
// attributes of a given Attack object.

public class Attack {
  private String name = "";
  private static final double DEFAULTMODIFIER = 1.0;
  private double baseDamageMod = DEFAULTMODIFIER;
  private double baseSpeedMod = DEFAULTMODIFIER;
  
  public Attack(String inName, double damageMod, double speedMod)
  {
    name = inName;
    baseDamageMod = damageMod;
    baseSpeedMod = speedMod;
  }
  
  public String GetName()
  {
    return name;
  }
  public double GetDamageMod(Limb limb)
  {
    double damageMod = 1.0;
    switch(limb)
    {
      case ARM -> damageMod = 0.9;
      case LEG -> damageMod = 1.2;
      case ELBOW -> damageMod = 0.0; // NOT YET FULLY IMPLEMENTED
      case SHIN -> damageMod = 0.0;  // NOT YET FULLY IMPLEMENTED
    }
    return baseDamageMod * damageMod;
  }
  public double GetSpeedMod(Limb limb)
  {
    double speedMod = 1.0;
    switch(limb)
    {
      case ARM -> speedMod = 1.3;
      case LEG -> speedMod = 0.8;
      case ELBOW -> speedMod = 0.0; // NOT YET FULLY IMPLEMENTED
      case SHIN -> speedMod = 0.0;  // NOT YET FULLY IMPLEMENTED
    }
    return baseSpeedMod * speedMod;
  }
}









// Old contents below. Keeping in case of later revisions.

/**
 * This class extention will hold attack options,
 * Including but not limited to; punch, kick, block...
 */
/*public class attack extends Fighter {
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
    
}*/
