package idleadventure;

import idleadventure.Caselles.Casella;
import idleadventure.Objectes.Objecte;
import idleadventure.Personatges.Personatge;
import idleadventure.Utils.cursorMoves;

public class printScreen {

    public static void Screen(Casella[][] caselles) {
        borders();
        //printSideView(caselles,heroPosition);
        // Mapa();
    }

    public static void canvas() {
        int canvasSize = 52;
        for (int i = 0; i < canvasSize; i++) {
            System.out.println();
        }
    }

    /**
     * Imprimeix la maquina
     *
     * @param colorFletxesStack Color de les fletxes del Stack de boles.
     */
    public static void borders() {
        int color = 31;
        cursorMoves.reset();
        System.out.print("\033[47F");
        // System.out.println("holis");
        System.out.printf("""
                ╔══════════════════════════════════════════════════════════════════════════════╗
                ║                                                                              ║
                ║                                  ADVENTURE                                   ║
                ║                                                                              ║
                ╠════════════════════════════════╦═════════════════════════════════════════════╣
                ║                                ║                                             ║
                ║                                ║  You wake up to the distant rustling of     ║
                ║                                ║  leaves and the soft patter of rain on      ║
                ║                                ║  canvas. The air is damp, carrying the      ║
                ║                                ║  scent of moss and pine.                    ║
                ║                                ║  As your eyes adjust to the dim moon light  ║
                ║                                ║  filtering through the tent’s fabric,       ║
                ║                                ║  confusion grips you, you don’t remember    ║
                ║                                ║  how you got here.                          ║
                ║                                ║                                             ║
                ║                                ║  Stepping outside, the forest stretches     ║
                ║                                ║  endlessly in every direction, unfamiliar   ║
                ║                                ║  yet eerily silent. There's no sign of a    ║
                ║                                ║  path, no footprints, no campfire embers    ║
                ║                                ║  just you, a tent, and a growing sense of   ║
                ║                                ║  unease.                                    ║
                ║                                ║                                             ║
                ║                                ║  The only clue is a small notebook in your  ║
                ║                                ║  pocket, its pages filled with cryptic      ║
                ║                                ║  symbols and half-erased words.             ║
                ║                                ║  Something brought you here.                ║
                ║                                ║  Something is watching.                     ║
                ║                                ║  And if you ever want to leave, you’ll      ║
                ║                                ║  have to uncover the truth before the       ║
                ║                                ║  forest swallows you whole.                 ║
                ║                                ║                                             ║
                ╠════════════════════════════════╬══════════════════════╦══════════════════════╣
                ║                                ║                      ║                      ║
                ║                                ║                      ║                      ║
                ║                                ║                      ║                      ║
                ║                                ║                      ║                      ║
                ║                                ║                      ║                      ║
                ║                                ║                      ║                      ║
                ║                                ║                      ║                      ║
                ║                                ║                      ║                      ║
                ║                                ║                      ║                      ║
                ║                                ║                      ║                      ║
                ║                                ║                      ║                      ║
                ║                                ║                      ║                      ║
                ║                                ║                      ║                      ║
                ║                                ║                      ║                      ║
                ╚════════════════════════════════╩══════════════════════╩══════════════════════╝
                """);
        cursorMoves.reset();

    }

    public static void gameMenu() {

        cursorMoves.moveXY(40, 33);
        System.out.println("""
                   Game

                \033[33C1- New Game
                \033[33C2- Credits
                \033[33C3- Exit
                \033[33C
                """);
        cursorMoves.reset();
    }

    public static void triaPersonatge() {

        cursorMoves.moveXY(34, 30);
        System.out.println("""
                Choose a character:

                \033[33C1- 👷  Warrior
                \033[33C2- 🧙  Mage
                \033[33C3- 🥷   Ninja
                \033[33C4- 🧛  Vampire
                """);
        cursorMoves.reset();
    }

    public static void Mapa(Casella[][] caselles, Personatge hero,int[] heroPosition) {
        cursorMoves.reset();
        cursorMoves.mapPosition();
        System.out.print("\033[2C");
        for (int f = 0; f < caselles.length; f++) {
            for (int c = 0; c < caselles[0].length; c++) {
                if(caselles[f][c].isPlayerOn()){
                    //System.out.print("🟥");
                    System.out.print(hero.getImatge());
                //if its in vision...
                }else if(f >= heroPosition[1]-hero.getIntel() && f <= heroPosition[1]+hero.getIntel() && c >= heroPosition[0]-hero.getIntel() && c <= heroPosition[0]+hero.getIntel()){
                            if (caselles[f][c].getNpc() != null) {
                                System.out.print(caselles[f][c].getNpc().getImatge());
                            }
                            else if (caselles[f][c].getMonstre() != null) {
                                System.out.print(caselles[f][c].getMonstre().getImatge());
                            }else{
                                System.out.print(caselles[f][c].getImatge());
                            }
                }else{
                    System.out.print("⬛");
                }
            }
            System.out.println();
            System.out.print("\033[2C");
        }
        cursorMoves.reset();
    }


    public static void menu(int[] menuPosition) {

        cursorMoves.moveXY(menuPosition[0], menuPosition[1]);
        System.out.println("""
                           Menu

                \033[3CW = Up        1 = Inspect
                \033[3CS = Down      2 = Talk
                \033[3CA = Left      3 = Fight
                \033[3CD = Right     4 = Give
                """);
        cursorMoves.reset();
    }

    public static void mostraInfoCasella(Casella[][] caselles,int[] infoPosition, int[] heroPosition){
        Casella casellaActual = caselles[heroPosition[1]][heroPosition[0]];
        //clear previous info
        cursorMoves.moveXY(infoPosition[0], infoPosition[1]);
        System.out.printf("""
                  Info Casella:

                \033[60C                  \s
                \033[60C                  \s
                \033[60C                  \s
                \033[60C                  \s
                \033[60C                  \s
                \033[60C                  \s
                \033[60C                  \s
                \033[60C                  \s
                \033[60C                  \s
                \033[60C                  \s
                \033[60C                  \s
                """);
        //add new info
        cursorMoves.moveXY(infoPosition[0], infoPosition[1]);
        casellaActual.mostraInfo();
        cursorMoves.reset();
    }

    public static void mostraInfoHeroe(int[] infoPosition,Personatge hero){
        cursorMoves.moveXY(infoPosition[0], infoPosition[1]);
        System.out.printf("""
                    Info Hero:

                \033[36C                   \s
                \033[36C                   \s
                \033[36C                   \s
                \033[36C                   \s
                \033[36C                   \s
                \033[36C                   \s
                \033[36C                   \s
                \033[36C                   \s
                \033[36C                   \s
                \033[36C                   \s
                \033[36C                   \s
                """);
        cursorMoves.moveXY(infoPosition[0], infoPosition[1]);
        System.out.printf("""
                    Info Hero:

                \033[36CNom:     %s
                \033[36CImatge:  %s
                \033[36CVida:    %d
                \033[36CMana:    %d
                \033[36CStamina: %d

                \033[36CSTR:  %s    EXP: %d
                \033[36CAGI:  %s
                \033[36CINT:  %s
                \033[36CDEX:  %s
                \033[36CLUCK: %s
                """,
                hero.getNom(),
                hero.getImatge(),
                hero.getVida(),
                hero.getMana(),
                hero.getStamina(),
                hero.getStr(),
                hero.getExp(),
                hero.getAgi(),
                hero.getIntel(),
                hero.getDex(),
                hero.getLuck());
        cursorMoves.reset();
    }

    public static void mostraInfoItemsHeroe(int[] infoPosition,Personatge hero){
        cursorMoves.moveXY(infoPosition[0], infoPosition[1]);
        System.out.printf("""
                    Items Hero:

                \033[36C                   \s
                \033[36C                   \s
                \033[36C                   \s
                \033[36C                   \s
                \033[36C                   \s
                \033[36C                   \s
                \033[36C                   \s
                \033[36C                   \s
                \033[36C                   \s
                \033[36C                   \s
                \033[36C                   \s
                """);
        cursorMoves.moveXY(infoPosition[0], infoPosition[1]);


        System.out.printf("""
                    Items Hero:

                """);
        int iterador = 1;
        for (Objecte objecte : hero.getItemsHero()) {
            System.out.println("\033[36C" + iterador + "- "+objecte.getNom()+"  "+objecte.getImatge()+"  x"+objecte.getQuantitat());
            iterador++;
        }
        cursorMoves.reset();
    }

    public static void printSideView(Casella[][] caselles,int[] heroPosition, String lastMovement, int time){
        int groundPosition = 25;
        int nextGroundPosition = 29;
        int thirdGroundPosition = 39;
        int celPosition = 42;
        Casella casellaActual = caselles[heroPosition[1]][heroPosition[0]];
        Casella casellaMes1 = casellaActual;
        Casella casellaMes2 = casellaActual;
        cursorMoves.reset();
        cursorMoves.moveup(celPosition);
        if(lastMovement.equals("w")){
            casellaMes1 = caselles[heroPosition[1] - 1][heroPosition[0]];
            casellaMes2 = caselles[heroPosition[1] - 2][heroPosition[0]];
        }else if(lastMovement.equals("s")){
            casellaMes1 = caselles[heroPosition[1] + 1][heroPosition[0]];
            casellaMes2 = caselles[heroPosition[1] + 2][heroPosition[0]];
        }else if(lastMovement.equals("a")){
            casellaMes1 = caselles[heroPosition[1]][heroPosition[0]-1];
            casellaMes2 = caselles[heroPosition[1]][heroPosition[0]-2];
        }else if(lastMovement.equals("d")){
            casellaMes1 = caselles[heroPosition[1]][heroPosition[0] + 1];
            casellaMes2 = caselles[heroPosition[1]][heroPosition[0] + 2];
        }
        //casellaActual.mostraPaisatge(4);
        switch (time) {
            case 0:
            case 1:
            System.out.printf("""
                \033[34C       *       * ⣠⣶⣿⣿⣶⡄     *          *     %1$s
                \033[34C        *        ⣿⣿⣿⣿⣿⣿    *              *  %1$s
                \033[34C  *         *    ⠹⢿⣿⣿⡿⠃         *            %1$s\033[0m
                    ""","");
                break;
            case 2:
            case 3:
            System.out.printf("""
                \033[34C      *            *       * ⣠⣶⣿⣿⣶⡄     *    %1$s
                \033[34C         *          *        ⣿⣿⣿⣿⣿⣿    *     %1$s
                \033[34C   *          *         *    ⠹⢿⣿⣿⡿⠃         *%1$s\033[0m
                    ""","");
                break;
            case 4:
            case 5:
            System.out.printf("""
                \033[34C       *          *            *       * ⣠⣶⣿⣿%1$s
                \033[34C      *              *          *        ⣿⣿⣿⣿%1$s
                \033[34C           *              *         *    ⠹⢿⣿⣿%1$s\033[0m
                    ""","");
                break;
            case 6:
            case 7:
            System.out.printf("""
                \033[34C*            *          *            *       %1$s
                \033[34C           *              *          *       %1$s
                \033[34C     *           *              *         *  %1$s\033[0m
                    ""","");
                break;
            case 8:
            case 9:
            System.out.printf("""
                \033[34C\033[33m ⣠⣶⣿⣿⣶⡄                                      %1$s
                \033[34C ⣿⣿⣿⣿⣿⣿                                      %1$s
                \033[34C ⠹⢿⣿⣿⡿⠃                                      %1$s\033[0m
                    ""","");
                break;
            case 10:
            case 11:
            System.out.printf("""
                \033[34C\033[33m          ⣠⣶⣿⣿⣶⡄                     %1$s
                \033[34C          ⣿⣿⣿⣿⣿⣿                             %1$s
                \033[34C          ⠹⢿⣿⣿⡿⠃                             %1$s\033[0m
                    ""","");
                break;
            case 12:
            case 13:
            System.out.printf("""
                \033[34C\033[33m                   ⣠⣶⣿⣿⣶⡄                    %1$s
                \033[34C                   ⣿⣿⣿⣿⣿⣿                    %1$s
                \033[34C                   ⠹⢿⣿⣿⡿⠃                    %1$s\033[0m
                    ""","");
                break;
            case 14:
            case 15:
            System.out.printf("""
                \033[34C\033[33m                              ⣠⣶⣿⣿⣶⡄         %1$s
                \033[34C                              ⣿⣿⣿⣿⣿⣿         %1$s
                \033[34C                              ⠹⢿⣿⣿⡿⠃         %1$s\033[0m
                    ""","");
                break;
            case 16:
            case 17:
            System.out.printf("""
                \033[34C\033[33m                                      ⣠⣶⣿⣿⣶⡄ %1$s
                \033[34C                                      ⣿⣿⣿⣿⣿⣿ %1$s
                \033[34C                                      ⠹⢿⣿⣿⡿⠃ %1$s\033[0m
                    ""","");
            
                break;
            case 18:
            case 19:
            System.out.printf("""
                \033[34C*            *          *            *       %1$s
                \033[34C           *              *          *      %1$s
                \033[34C     *           *              *         *  %1$s\033[0m
                    ""","");
                break;
            case 20:
            case 21:
            System.out.printf("""
                \033[34C⣠⣶⣿⣿⣶⡄*            *          *            * %1$s
                \033[34C⣿⣿⣿⣿⣿⣿           *              *          *%1$s
                \033[34C⠹⢿⣿⣿⡿⠃     *           *              *      %1$s\033[0m
                    ""","");
                break;
            case 22:
            case 23:
            System.out.printf("""
                \033[34C         * ⣠⣶⣿⣿⣶⡄*            *          *   %1$s
                \033[34C          *⣿⣿⣿⣿⣿⣿           *              * %1$s
                \033[34C    *      ⠹⢿⣿⣿⡿⠃     *           *          %1$s\033[0m
                    ""","");
                break;
            default:
                throw new AssertionError();
        }
        
        cursorMoves.reset();
        //cursorMoves.moveup(thirdGroundPosition);
        casellaMes2.mostraPaisatge(3,thirdGroundPosition);
        
        cursorMoves.reset();
        //cursorMoves.moveup(nextGroundPosition);
        casellaMes1.mostraPaisatge(2,nextGroundPosition);
        
        cursorMoves.reset();
        //cursorMoves.moveup(groundPosition);
        casellaActual.mostraPaisatge(1,groundPosition);
        cursorMoves.reset();

    }

}
