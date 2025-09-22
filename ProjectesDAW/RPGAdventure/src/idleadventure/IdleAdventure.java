/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package idleadventure;

import idleadventure.Caselles.Casella;
import idleadventure.Personatges.GM;
import idleadventure.Personatges.PerMage;
import idleadventure.Personatges.PerNinja;
import idleadventure.Personatges.PerVampire;
import idleadventure.Personatges.PerWarrior;
import idleadventure.Personatges.Personatge;

/**
 *
 * @author borras
 */
public class IdleAdventure {

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Casella caselles[][] = new Casella[26][15];
        gameManager gm = new gameManager();
        boolean gameRunning = false;
        int opcioPersonatge;
        Personatge hero = new PerWarrior();
        

        int mapa1[][] = {
            {7 ,7 ,7 ,7 ,7 ,7 ,7 ,7 ,5 ,9 ,5 ,5 ,7 ,7 ,7 },
            {7 ,7 ,7 ,7 ,7 ,5 ,5 ,5 ,5 ,9 ,5 ,5 ,5 ,7 ,7 },
            {7 ,7 ,7 ,5 ,5 ,6 ,5 ,5 ,5 ,9 ,6 ,6 ,5 ,5 ,7 },
            {7 ,7 ,5 ,6 ,6 ,6 ,6 ,5 ,9 ,9 ,11,6 ,6 ,5 ,7 },
            {7 ,7 ,5 ,6 ,10,6 ,6 ,6 ,9 ,11,11,6 ,6 ,5 ,7 },
            {7 ,5 ,5 ,6 ,6 ,6 ,6 ,6 ,9 ,11,11,6 ,6 ,5 ,7 },
            {7 ,7 ,5 ,5 ,5 ,5 ,5 ,6 ,9 ,11,11,6 ,6 ,5 ,7 },
            {7 ,7 ,7 ,7 ,5 ,6 ,6 ,6 ,9 ,11,11,11,6 ,5 ,7 },
            {7 ,7 ,7 ,7 ,7 ,5 ,6 ,6 ,9 ,11,11,11,6 ,5 ,7 },
            {7 ,7 ,7 ,5 ,5 ,5 ,6 ,6 ,9 ,11,11,6 ,6 ,5 ,7 },
            {7 ,5 ,5 ,5 ,6 ,6 ,6 ,11,9 ,11,6 ,6 ,6 ,5 ,7 },
            {7 ,5 ,5 ,6 ,6 ,6 ,11,11,9 ,6 ,6 ,6 ,6 ,5 ,7 },
            {7 ,5 ,6 ,6 ,9 ,9 ,9 ,9 ,9 ,6 ,6 ,6 ,6 ,5 ,7 },
            {7 ,5 ,6 ,6 ,9 ,6 ,6 ,6 ,6 ,6 ,6 ,6 ,6 ,5 ,7 },
            {7 ,5 ,6 ,6 ,8 ,6 ,6 ,6 ,6 ,6 ,6 ,6 ,6 ,5 ,7 },
            {7 ,5 ,6 ,6 ,9 ,6 ,6 ,6 ,6 ,6 ,6 ,6 ,5 ,5 ,7 },
            {7 ,5 ,6 ,12,9 ,9 ,6 ,6 ,6 ,9 ,9 ,9 ,5 ,5 ,7 },
            {7 ,5 ,6 ,6 ,6 ,9 ,6 ,6 ,9 ,9 ,9 ,9 ,9 ,5 ,7 },
            {7 ,5 ,11,11,11,9 ,9 ,9 ,9 ,9 ,9 ,9 ,9 ,9 ,7 },
            {7 ,5 ,5 ,11,11,11,11,6 ,9 ,9 ,9 ,9 ,9 ,9 ,7 },
            {7 ,5 ,5 ,5 ,11,11,6 ,6 ,6 ,9 ,9 ,9 ,9 ,9 ,7 },
            {7 ,5 ,5 ,6 ,6 ,6 ,6 ,6 ,6 ,6 ,9 ,9 ,9 ,9 ,7 },
            {7 ,5 ,6 ,6 ,6 ,6 ,6 ,6 ,6 ,6 ,6 ,9 ,6 ,5 ,7 },
            {7 ,5 ,6 ,6 ,6 ,6 ,6 ,6 ,6 ,6 ,6 ,8 ,6 ,15,7 },
            {7 ,5 ,5 ,5 ,5 ,5 ,5 ,5 ,5 ,5 ,5 ,9 ,6 ,5 ,7 },
            {7 ,7 ,7 ,7 ,7 ,7 ,7 ,7 ,7 ,7 ,7 ,9 ,7 ,7 ,7 }
        };
        
        int mapa2[][] = {};
        //Starting aplication
        printScreen.canvas();
        
        
        int opcio = gm.gameMenu();
        
        switch (opcio) {
            case 1:
                opcioPersonatge = gm.triaPersonatge();
                switch (opcioPersonatge) {
                    case 1:
                        hero = new PerWarrior();
                        break;
                    case 2:
                        hero = new PerMage();
                        break;
                    case 3:
                        hero = new PerNinja();
                        break;
                    case 4:
                        hero = new PerVampire();
                        break;
                    case 5:
                        hero = new GM();
                        break;
                    default:
                        throw new AssertionError();
                }
                gameRunning = true;
                printScreen.Screen(caselles);
                gm.omplirCaselles(caselles,mapa1);
                //gm.updateMap(caselles);
                gm.spawnPlayer(caselles);
                gm.populateMap(caselles,hero);
                gm.updateMap(caselles,hero);
                gm.showMenu();
                gm.mostraInfoWindows(caselles, hero);
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            default:
                throw new AssertionError();
        }

        

        //Game loop starts now!
        while (gameRunning) { 
        gm.fesAccio(caselles,hero);
        
        //gm.updateMap(caselles);
       }
           
    }
}
