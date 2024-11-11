/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._prog1;
import java.util.ArrayList;
/**
 * TBD at future date
 * Fighter Format:Fighter(String inName, Country country, int force, int intelligence, int grit, int hold, int technique, int execution, int resilience)
 */
public class Story_Mode 
{
    public Story_Mode()
    {
        ArrayList<Fighter> opponents = new ArrayList<Fighter>();
        fillOpponents();
    }
    public static void fillOpponents ()
    {
        opponents.add(Fighter("manman", MEXICO, 2, 0, 9, 1, 2, 9, 9));
    }
}
