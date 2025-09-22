/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package idleadventure;

import idleadventure.Caselles.Casella;
import idleadventure.Caselles.caBosc;
import idleadventure.Caselles.caCampFire;
import idleadventure.Caselles.caDerelictHouse;
import idleadventure.Caselles.caHerba;
import idleadventure.Caselles.caMontanya;
import idleadventure.Caselles.caPomers;
import idleadventure.Caselles.caPont;
import idleadventure.Caselles.caTeleport;
import idleadventure.Caselles.caWater;
import idleadventure.Monstres.Beetle;
import idleadventure.Monstres.Spider;
import idleadventure.NPC.PoliceMan;
import idleadventure.NPC.Worker;
import idleadventure.Objectes.ObBox;
import idleadventure.Objectes.ObNotebook;
import idleadventure.Objectes.ObPal;
import idleadventure.Objectes.ObPen;
import idleadventure.Personatges.Personatge;
import idleadventure.Utils.cursorMoves;
import idleadventure.Utils.dryUtils;
import java.util.Scanner;

/**
 *
 * @author borras
 */
public class gameManager {

    Scanner teclat = new Scanner(System.in);

    // Game positions bottom-top, left-right
    int gameMenuPosition[] = { 14, 4 };
    int menuPosition[] = { 14, 4 };
    int promptPosition[] = { 4, 4 };
    int inputPosition[] = { 3, 4 };
    int infoCasellaPosition[] = { 14, 60 };
    int infoHeroePosition[] = { 14, 36 };
    String lastMovement = "0";
    int time = 0;
    int maxActionPerTime = 20;
    int actionPerTime = maxActionPerTime;

    // Game Map positions left-right, top-bottom
    int spawnPosition[] = { 4, 4 };
    int heroPosition[] = spawnPosition;

    public void omplirCaselles(Casella[][] caselles, int[][] mapa) {
        for (int f = 0; f < caselles.length; f++) {
            for (int c = 0; c < caselles[0].length; c++) {
                int caID = mapa[f][c];
                int posicio[] = { f, c };
                switch (caID) {
                    case 0:
                        caselles[f][c] = new caHerba(posicio);
                        break;
                    case 5:
                        caselles[f][c] = new caBosc(posicio);
                        break;
                    case 6:
                        caselles[f][c] = new caHerba(posicio);
                        break;
                    case 7:
                        caselles[f][c] = new caMontanya(posicio);
                        break;
                    case 8:
                        caselles[f][c] = new caPont(posicio);
                        break;
                    case 9:
                        caselles[f][c] = new caWater(posicio);
                        break;
                    case 10:
                        caselles[f][c] = new caCampFire(posicio);
                        break;
                    case 11:
                        caselles[f][c] = new caPomers(posicio);
                        break;
                    case 12:
                        caselles[f][c] = new caDerelictHouse(posicio);
                        break;
                    case 15:
                        caselles[f][c] = new caTeleport(posicio);
                        break;
                    default:
                        caselles[f][c] = new caHerba(posicio);
                }
            }
        }
    }

    public void spawnPlayer(Casella[][] caselles) {
        caselles[spawnPosition[0]][spawnPosition[1]].setPlayerOn(true);
    }

    public void updateMap(Casella[][] caselles, Personatge hero) {
        printScreen.Mapa(caselles, hero, heroPosition);
    }

    public void showMenu() {
        printScreen.menu(menuPosition);
    }

    public void fesAccio(Casella[][] caselles, Personatge hero) {
        String accioEscollida;
        Casella casellaActual = caselles[heroPosition[1]][heroPosition[0]];

        do {
            cursorMoves.moveXY(promptPosition[0], promptPosition[1]);
            System.out.print("Quina acció vols fer? ");
            cursorMoves.moveXY(inputPosition[0], inputPosition[1]);
            System.out.print("                    \033[20D");
            accioEscollida = teclat.nextLine().toLowerCase();
            if (accioEscollida.length() == 0 || accioEscollida.length() >= 2) {
                cursorMoves.moveXY(promptPosition[0] + 1, promptPosition[1]);
                System.out.print("No es una opcio valida.");
            }
        } while (accioEscollida.length() == 0 || accioEscollida.length() >= 2);

        cursorMoves.moveXY(promptPosition[0] + 4, promptPosition[1]);
        System.out.println("                            ");
        System.out.println("\033[2C                              ");
        System.out.println("\033[2C                              ");
        System.out.println("\033[2C                              ");

        switch (accioEscollida) {
            case "w":
                if (!hero.isCanFly()) {
                    if (!caselles[heroPosition[1] - 1][heroPosition[0]].isWalkable() ||
                            (caselles[heroPosition[1] - 1][heroPosition[0]].getNpc() != null
                                    && !caselles[heroPosition[1] - 1][heroPosition[0]].getNpc().isWalkable())) {
                        lastMovement = "w";
                    } else {
                        casellaActual.setPlayerOn(false);
                        caselles[heroPosition[1] - 1][heroPosition[0]].setPlayerOn(true);
                        heroPosition[1] -= 1;
                        hero.setStamina(hero.getStamina() - 1);
                        lastMovement = "w";
                        actionPerTime--;
                    }
                }else {
                    casellaActual.setPlayerOn(false);
                    caselles[heroPosition[1] - 1][heroPosition[0]].setPlayerOn(true);
                    heroPosition[1] -= 1;
                    hero.setStamina(hero.getStamina() - 1);
                    lastMovement = "w";
                    actionPerTime--;
                }
                break;
            case "s":
            if (!hero.isCanFly()) {
                if (!caselles[heroPosition[1] + 1][heroPosition[0]].isWalkable() ||
                        (caselles[heroPosition[1] + 1][heroPosition[0]].getNpc() != null
                                && !caselles[heroPosition[1] + 1][heroPosition[0]].getNpc().isWalkable())) {
                    lastMovement = "s";
                } else {
                    casellaActual.setPlayerOn(false);
                    caselles[heroPosition[1] + 1][heroPosition[0]].setPlayerOn(true);
                    heroPosition[1] += 1;
                    hero.setStamina(hero.getStamina() - 1);
                    lastMovement = "s";
                    actionPerTime--;
                }
            }else {
                casellaActual.setPlayerOn(false);
                caselles[heroPosition[1] + 1][heroPosition[0]].setPlayerOn(true);
                heroPosition[1] += 1;
                hero.setStamina(hero.getStamina() - 1);
                lastMovement = "s";
                actionPerTime--;
            }
                break;
            case "a":
            if (!hero.isCanFly()) {
                if (!caselles[heroPosition[1]][heroPosition[0] - 1].isWalkable() ||
                        (caselles[heroPosition[1]][heroPosition[0] - 1].getNpc() != null
                                && !caselles[heroPosition[1]][heroPosition[0] - 1].getNpc().isWalkable())) {
                    lastMovement = "a";
                } else {
                    casellaActual.setPlayerOn(false);
                    caselles[heroPosition[1]][heroPosition[0] - 1].setPlayerOn(true);
                    heroPosition[0] -= 1;
                    hero.setStamina(hero.getStamina() - 1);
                    lastMovement = "a";
                    actionPerTime--;
                }
            }else {
                casellaActual.setPlayerOn(false);
                caselles[heroPosition[1]][heroPosition[0] - 1].setPlayerOn(true);
                heroPosition[0] -= 1;
                hero.setStamina(hero.getStamina() - 1);
                lastMovement = "a";
                actionPerTime--;
            }
                break;
            case "d":
            if (!hero.isCanFly()) {
                if (!caselles[heroPosition[1]][heroPosition[0] + 1].isWalkable() ||
                        (caselles[heroPosition[1]][heroPosition[0] + 1].getNpc() != null
                                && !caselles[heroPosition[1]][heroPosition[0] + 1].getNpc().isWalkable())) {
                    lastMovement = "d";
                } else {
                    casellaActual.setPlayerOn(false);
                    caselles[heroPosition[1]][heroPosition[0] + 1].setPlayerOn(true);
                    heroPosition[0] += 1;
                    hero.setStamina(hero.getStamina() - 1);
                    lastMovement = "d";
                    actionPerTime--;
                }
            }else {
                casellaActual.setPlayerOn(false);
                caselles[heroPosition[1]][heroPosition[0] + 1].setPlayerOn(true);
                heroPosition[0] += 1;
                hero.setStamina(hero.getStamina() - 1);
                lastMovement = "d";
                actionPerTime--;
            }
                break;
            case "1":
                if (casellaActual.getMonstre() != null) {
                    casellaActual.getMonstre().interact(hero);
                    hero.setStamina(hero.getStamina() - 1);
                }
                if (casellaActual.getNpc() != null) {
                    casellaActual.getNpc().interact(hero);
                    hero.setStamina(hero.getStamina() - 1);
                }
                break;
            case "2":
                if (casellaActual.getMonstre() != null) {
                    casellaActual.getMonstre().talk();
                    hero.setStamina(hero.getStamina() - 1);
                }
                if (casellaActual.getNpc() != null) {
                    casellaActual.getNpc().talk();
                    hero.setStamina(hero.getStamina() - 1);
                }
                break;
            case "3":
                if (casellaActual.getMonstre() != null) {
                    // resta vida del combat
                    hero.setVida(hero.getVida() - casellaActual.getMonstre().getStr());
                    casellaActual.getMonstre().setVida(casellaActual.getMonstre().getVida() - hero.getStr());

                    // kill monster
                    if (casellaActual.getMonstre().getVida() <= 0) {
                        // suma exp
                        hero.setExp(hero.getExp() + casellaActual.getMonstre().getExpGiven());
                        casellaActual.setMonstre(null);
                    }
                    hero.setStamina(hero.getStamina() - 1);
                } else if (casellaActual.getNpc() != null) {
                    // resta vida del combat
                    hero.setVida(hero.getVida() - casellaActual.getNpc().getStr());
                    casellaActual.getNpc().setVida(casellaActual.getNpc().getVida() - hero.getStr());

                    // kill monster
                    if (casellaActual.getNpc().getVida() <= 0) {
                        // suma exp
                        hero.setExp(hero.getExp() + casellaActual.getNpc().getExpGiven());
                        casellaActual.setNpc(null);
                    }
                    hero.setStamina(hero.getStamina() - 1);
                }
                break;
            case "4":
                printScreen.mostraInfoItemsHeroe(infoHeroePosition, hero);
                cursorMoves.moveXY(promptPosition[0], promptPosition[1]);
                // casellaActual.getNpc().give(hero.,caselles);
                return;
            // break;
            default:
                ;
        }
        if (actionPerTime <= 0) {
            time++;
            actionPerTime = maxActionPerTime;
        }
        if (time >= 24) {
            time = 0;
        }

        printScreen.printSideView(caselles, heroPosition, lastMovement, time);
        updateMap(caselles, hero);
        printScreen.mostraInfoCasella(caselles, infoCasellaPosition, heroPosition);
        printScreen.mostraInfoHeroe(infoHeroePosition, hero);
    }

    public int gameMenu() {
        printScreen.gameMenu();
        cursorMoves.moveXY(30, 37);
        int opcio = dryUtils.triaOpcio(3);
        cursorMoves.reset();
        return opcio;
    }

    public int triaPersonatge() {
        printScreen.triaPersonatge();
        cursorMoves.moveXY(20, 37);
        int opcio = dryUtils.triaOpcio(5);
        cursorMoves.reset();
        return opcio;
    }

    public void mostraInfoWindows(Casella[][] caselles, Personatge hero) {
        printScreen.mostraInfoCasella(caselles, infoCasellaPosition, heroPosition);
        printScreen.mostraInfoHeroe(infoHeroePosition, hero);
    }

    public void populateMap(Casella[][] caselles, Personatge hero) {
        caselles[7][5].setMonstre(new Spider());
        caselles[2][5].setMonstre(new Beetle());
        caselles[5][1].setMonstre(new Beetle());
        caselles[14][9].setNpc(new PoliceMan());
        caselles[14][3].setNpc(new Worker());
        // populate inventory. testing
        hero.addItem(new ObPal());
        hero.addItem(new ObPen());
        hero.addItem(new ObBox());
        hero.addItem(new ObNotebook());
    }
}
