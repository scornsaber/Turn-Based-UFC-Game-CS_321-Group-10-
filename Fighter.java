/*
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



import java.lang.Math;

public class Fighter {
  
  private String name = "";
  private Country countryOfOrigin = USA;  // Default value. Determined in parameterized constructor.
  private int baseHP = 100;           // Default value. Might change depending on character creation.
  private int HP = baseHP;
  private static final int baseEnergy = 100; // Base value for all Fighters. Cannot be changed.
  private int energy = baseEnergy;
  private static final int DEFAULTSTAT = 20; // Minimum value for most stats. Used when player is Level 1.
  private int attack = DEFAULTSTAT;
  private int defense = DEFAULTSTAT;
  private int speed = DEFAULTSTAT;
  
  private int fitness=DEFAULTSTAT;    // Will affect stamina cost of attacks.
  private int recovery=DEFAULTSTAT;   // Affects stamina recovery rate.
  
  private int chip = 0;               // Increases damage dealt on blocking target.
  private int block = 0;              // Decreases damage taken while blocking.
  private int grapple = 0;            // Increases efficacy of grapples. (NOT YET IMPLEMENTED)
  private int dodge = 0;              // Decreases energy cost of dodging.
  //Invisible Stats
  private int grappleResistance = 0;  // These are more specific values, so
  private int strongAttack = 0;       // they start at 0 and are raised only through
                                      // level-ups.
  
  private boolean isBlocking = false;
  private boolean isBurntOut = false; // Handled in Battle. Fighter becomes burnt out if they reach
                                      // 0 energy. Damage and defense are drastically reduced when
                                      // burnt out, so energy management is essential to combat.
  
  public Fighter(String inName)       // Basic constructor. Will update later.
  {
    name = inName;
  }
  
  //Parameterized constructor:
  public Fighter(String inName, Country country, int force, int intelligence, int grit, int hold, int technique, int execution, int resilience)
  {
    // The input values come from the level up points (F.I.G.H.T.E.R.)
    // These values add to the character's base stats, as written below.
    /*
    F	Force			(Attack+2, Chip+1)                  Increases damage and chip damage.
    I	Intelligence	(Recovery+3, grappleResist+1)   Increases energy regeneration and grapple escape chance.
    G	Grit			(Defense+3,ChipResist+1)            Decreases all damage taken.
    H	Hold			(Grapple+3)                         Grapples more likely to succeed, and do more damage.
    T	Technique		(Speed+2, Dodge+1)                Attack faster, dodging uses less energy
    E	Execution		(Fitness+3, StrongAttacks+1)      Attacks use less energy. Strong attacks do slightly more damage.
    R	Resilience		(Block+3,chipResist+2)          Decreases chip damage taken. Blocking is more effective. (Lower chance of failure on repeats)
    */
   
    name = inName;
    countryOfOrigin = country;
    
    // Stat allocation:
    attack += 2*force;            chip ++ force;                  // Force
    recovery += 3*intelligence;   grappleResist += intelligence;  // Intelligence
    defense += 3*grit;            chipResist += grit;             // Grit
    grapple += 3*hold;                                            // Hold
    speed += 2*technique;         dodge += technique;             // Technique
    fitness += 3*execution;       strongAttack += execution;      // Execution
    block += 3*resilience;        chipResist += 2*resilience;     // Resilience

  }
  
  public string GetName()
  {
    return name;
  }
  public static void CreateFighter(Fighter newFighter) // Not yet implemented.
  {
    
  }
  
  public int GetHP()
  {
    return HP;
  }
  public void ResetFighter() // For use after Battle finishes.
  {
    HP = baseHP;
    energy = baseEnergy;
  }
  public int DealDamage(int damage) // Subtracts damage from HP, returns HP.
  {
    HP = HP - damage;
    if (HP<0) {HP = 0;}
    return HP;
  }
  
  public int GetDefense()
  {
    return defense;
  }
  public boolean GetBlock()
  {
    return isBlocking;
  }
  public double GetBlockMod()  // If Fighter is blocking, damage taking is significantly reduced.
  {
    return 3.0 + (0.05*block); // Base damage reduction of 3x, and this reduction is increased by 0.05x
                               // for every point invested in Fighters' "block" skill.
  }
  public void SetBlock(boolean input) // Handled by Battle class.
  {
    isBlocking = input;
  }
  public boolean GetBurnout()         // Burnout is handled completely by Battle class.
  {
    return isBurntOut;
  }
  public void SetBurnout(boolean input)
  {
    isBurntOut = input;
  }
  
  public void GetAttackChoice(Attack &attackChoice, Limb &limbChoice) // This will be implented later and handled in GUI.
  {
    attackChoice = Attack();  // PLACEHOLDER VALUE. WILL NOT BE PRESENT IN FINAL FUNCTION.
    limbPtr = ARM;            // PLACEHOLDER VALUE. WILL BE DIFFERENT IN FINAL FUNCTION.
  }

  public int GetAttackDamage(Attack attackChoice, Fighter target, Limb limb) // Calculates damage dealt, returns value as long int.
  {
    int damage = 1; // Default value for initialization.
    
    // First, calculate effective modifiers for each.
    double effectiveAttack = attack;
    if (attackChoice.GetDamageMod(limb)>1.0) // Chosen attack is a strong attack.
    {
      effectiveAttack = attack + (strongAttack * 0.05);
    }
    if (isBurntOut == true) // Attack is halved if player is burnt out.
    {
      effectiveAttack = effectiveAttack * 0.5;
    }
    double effectiveDefense = target.GetDefense();
    if (target.GetBlock() == true)
    {
      effectiveDefense = effectiveDefense*(target.GetBlockMod() - (0.1*chip));
    }
    
    // Now do the calculations.
    final int DAMAGECONSTANT = 5; // Arbitrary number used in video game damage functions.
                                  // 5 was found empirically to be the msot effective for this game.
    damage = (int) Math.round((((13*effectiveAttack)-(8*effectiveDefense))/DAMAGECONSTANT)*attackChoice.GetDamageMod(limb));
    if (damage < 1) {damage = 1;}
    return damage;                // Returns damage to Battle, which then applies it to Fighters in the correct order.
  }
  
  public int GetAttackSpeed(Attack attackChoice, Limb limb) // Gets speed of a certain Attack by this fighter.
  {                                                         // Used in Battle class.
    int attackSpeed = (int) Math.round(speed * attackChoice.GetSpeedMod(limb));
    if (isBurntOut == true)
    {
      attackSpeed *= 0.5; // Speed is halved if user is burnt out.
    }
    if (attackSpeed < 1) // This should never happen.
    {
      attackSpeed = 1;
    }
    return attackSpeed;
  }


  
  // I only use the below function in personal tests. Will be removing later.
  public long AttackTest(int userAttack, int targetDefense, double attackModifier)
  {
    final int DAMAGECONSTANT = 5;
    long damage = 0; // Output variable
    
    damage = Math.round((((13*userAttack)-(8*targetDefense))/DAMAGECONSTANT)*attackModifier);
    if (damage < 1) {damage = 1;}
    return damage;
  }

   // Method to save fighter's information to a file added by Caleb
    public void SaveToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Name: " + name + "\n");
            writer.write("HP: " + HP + "\n");
            writer.write("Energy: " + energy + "\n");
            writer.write("Attack: " + attack + "\n");
            writer.write("Defense: " + defense + "\n");
            writer.write("Speed: " + speed + "\n");
            writer.write("Fitness: " + fitness + "\n");
            writer.write("Recovery: " + recovery + "\n");
            writer.write("Chip: " + chip + "\n");
            writer.write("Block: " + block + "\n");
            writer.write("Grapple: " + grapple + "\n");
            writer.write("Dodge: " + dodge + "\n");
            writer.write("GrappleResistance: " + grappleResistance + "\n");
            writer.write("StrongAttack: " + strongAttack + "\n");
            writer.write("IsBlocking: " + isBlocking + "\n");
            writer.write("IsBurntOut: " + isBurntOut + "\n");
            System.out.println("Fighter information saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving fighter information.");
            e.printStackTrace();
        }
    }

    // Static method to load fighter's information from a file
    public static Fighter LoadFromFile(String fileName) {
        Fighter loadedFighter = new Fighter("");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                switch (parts[0]) {
                    case "Name":
                        loadedFighter.name = parts[1];
                        break;
                    case "HP":
                        loadedFighter.HP = Integer.parseInt(parts[1]);
                        break;
                    case "Energy":
                        loadedFighter.energy = Integer.parseInt(parts[1]);
                        break;
                    case "Attack":
                        loadedFighter.attack = Integer.parseInt(parts[1]);
                        break;
                    case "Defense":
                        loadedFighter.defense = Integer.parseInt(parts[1]);
                        break;
                    case "Speed":
                        loadedFighter.speed = Integer.parseInt(parts[1]);
                        break;
                    case "Fitness":
                        loadedFighter.fitness = Integer.parseInt(parts[1]);
                        break;
                    case "Recovery":
                        loadedFighter.recovery = Integer.parseInt(parts[1]);
                        break;
                    case "Chip":
                        loadedFighter.chip = Integer.parseInt(parts[1]);
                        break;
                    case "Block":
                        loadedFighter.block = Integer.parseInt(parts[1]);
                        break;
                    case "Grapple":
                        loadedFighter.grapple = Integer.parseInt(parts[1]);
                        break;
                    case "Dodge":
                        loadedFighter.dodge = Integer.parseInt(parts[1]);
                        break;
                    case "GrappleResistance":
                        loadedFighter.grappleResistance = Integer.parseInt(parts[1]);
                        break;
                    case "StrongAttack":
                        loadedFighter.strongAttack = Integer.parseInt(parts[1]);
                        break;
                    case "IsBlocking":
                        loadedFighter.isBlocking = Boolean.parseBoolean(parts[1]);
                        break;
                    case "IsBurntOut":
                        loadedFighter.isBurntOut = Boolean.parseBoolean(parts[1]);
                        break;
                }
            }
            System.out.println("Fighter information loaded from " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while loading fighter information.");
            e.printStackTrace();
        }
        return loadedFighter;
    }

    // Example of how to save and load fighter
    //Fighter fighter = new Fighter("John Doe");
    //fighter.SaveToFile("fighter.txt");
    //Fighter LoadedFighter = Fighter.loadFromFile("fighter.txt");
    //System.out.println("Loaded Fighter: " + loadedFighter.getName())
}






// Old contents below for tracking changes. 
// I (Ethan Watts) completely reworked the class before properly
// linking GitHub and NetBeans, so the above information was just
// copy-pasted from a test project on my personal computer.



/*
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
*/
