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
    static ArrayList<Fighter> opponents = new ArrayList<Fighter>();
    public Story_Mode()
    {
        fillOpponents();
    }
    public static void fillOpponents ()
    {
        opponents.add(Fighter("manman", MEXICO, 2, 0, 9, 1, 2, 9, 9));
        opponents.add(Fighter("manman", MEXICO, 2, 0, 9, 1, 2, 9, 9));
        opponents.add(Fighter("manman", MEXICO, 2, 0, 9, 1, 2, 9, 9));
        opponents.add(Fighter("manmn", MEXICO, 2, 0, 9, 1, 2, 9, 9));
        opponents.add(Fighter("manman", MEXICO, 2, 0, 9, 1, 2, 9, 9));
        opponents.add(Fighter("manman", MEXICO, 2, 0, 9, 1, 2, 9, 9));
        opponents.add(Fighter("Fedora Emily", RUSSIA, 7, 10, 8, 4, 5, 6, 9));
        opponents.add(Fighter("Andy Silver", BRAZIL, 7, 8, 4, 9, 6, 9, 5));
        opponents.add(Fighter("Donald John", USA, 5, 9, 7, 9, 8, 8, 6));
        opponents.add(Fighter("Gregory Pier", USA, 6, 8, 10, 5, 9, 9, 10));
    }
}
