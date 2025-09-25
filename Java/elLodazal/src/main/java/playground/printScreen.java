package playground;

import java.util.ArrayList;

public class printScreen {
    
    public static void Screen(objects.Roda lesrodes[][],int coins,ArrayList<objects.Bola> lesBoles,int spins,int stackBolesPosition[],int colorFletxesStack){
        borders(colorFletxesStack);
        menu(coins,lesBoles,spins);
        rodes(lesrodes);
        boles(lesBoles);
        stackBoles(lesBoles,stackBolesPosition);
    }


    
    public static void canvas(){
        int canvasSize = 80; 
        for (int i = 0; i < canvasSize; i++) {
            System.out.println();
        }
    }


    /**
     * Imprimeix la maquina
     * @param colorFletxesStack Color de les fletxes del Stack de boles.
     */
    public static void borders(int colorFletxesStack){
        int color = 31;
        color = colorFletxesStack;
        cursorMoves.reset();
        System.out.print("\033[47F");
        System.out.printf("""
            ╔═══════════════════════════════════════════════════════╦══════════════════════╗
            ║                                                  ╔🕳️ ╗ ║                      ║
            ║                    EL LODAZAL                    ║  ║ ║                      ║
            ║                                                  ║  ║ ║                      ║
            ║                                                  ║  ║ ║                      ║
            ║                                                  ║  ║ ║                      ║
            ║                                                  ║  ║ ║                      ║
            ║                                                  ║  ║ ║                      ║
            ║                                                  ║  ║ ║                      ║
            ║                                                  ║  ║ ║                      ║
            ║                                                  ║  ║ ║                      ║
            ║                                                  ║  ║ ║                      ║
            ║                                                  ║  ║ ║                      ║
            ║                                                  ║  ║ ║                      ║
            ║                                                  ║  ║ ║                      ║
            ║                                                  ║  ║ ║                      ║
            ║                                                  ║  ║ ║                      ║
            ║                                                  ║  ║ ║                      ║
            ║                                                  ║  ║ ║                      ║
            ║                                                  ║  ║ ║                      ║
            ║                                                  ║  ║ ║                      ║
            ║                                                  ║  ║ ║                      ║
            ║                                                  ║  ║ ║                      ║
            ║                                                  ║  ║ ║                      ║
            ╠═══════════════════════╦══════════════════════════╝  ╠═╣                      ║
            ║                       ║                             ║ ║                      ║
            ║                       ║🕳️ ╔══════════════════════════╝ ║                      ║
            ║                                                       ║                      ║
            ║                   \033[%dm 🡆       🡄\033[0m                          ║                      ║
            ║                                                       ║                      ║
            ║                        📍                             ║                      ║
            ║                                                       ║                      ║
            ║                    📍      📍                         ║                      ║
            ║                                                       ║                      ║
            ║                📍      📍      📍                     ║                      ║
            ║                                                       ║                      ║
            ║            📍      📍      📍      📍                 ║                      ║
            ║                                                       ║                      ║
            ║        📍      📍      📍      📍      📍             ║                      ║
            ║                                                       ║                      ║
            ║                                                       ║                      ║
            ║    x16      x8      x2      x2     x8      x16        ║                      ║
            ║ ║       ║       ║       ║       ║       ║      ║      ╠                      ╣
            ║ ╚═══════╩═══════╩═══════╩═══════╩═══════╩══════╝      ║                      ║
            ║                                                       ║                      ║
            ║                                                       ║                      ║
            ╚═══════════════════════════════════════════════════════╩══════════════════════╝
            """,colorFletxesStack);
        cursorMoves.reset();

    }

    /**
     * Imprimeix el menu de la maquina.
     * @param coins Les monedes que te la maquina
     * @param lesBoles Les boles que te la maquina.
     * @param spins Els spins que te la maquina.
     */
    public static void menu(int coins,ArrayList<objects.Bola> lesBoles,int spins){
        int positionMenu[] = {45,60}; 
        cursorMoves.moveXY(positionMenu[0],positionMenu[1]);
        // pot ser "s" o "d" ¿?¿? 
        System.out.printf("""

                \033[%1$sC  1€ = 1 Spin


                \033[%sC     Actions
                \033[%1$sC-----------------
                \033[%1$sC1- Insert Coin
                \033[%1$dC2- Cash money
                \033[%1$dC3- Pull Lever
                \033[%1$sC\033[9m4- Hit Machine\033[29m
                \033[%1$sC5- Let Balls Fall
                \033[%1$sC6- Quit

                \033[%1$sCCoins: %5$d
                \033[%1$sCSpins: %d
                \033[%1$sCBalls: %d


                \033[%1$sC    Action:



                

                \033[%1$sC    Jackpots
                \033[%1$sC----------------
                \033[%1$sC⚪⚪⚪⚪ =  3 ⚪

                \033[%1$sC🍒🍒🍒🍒 =  10 €

                \033[%1$sC🍉🍉🍉🍉 =  20 €

                \033[%1$sC💍💍💍💍 =  50 €

                \033[%1$sC💲💲💲💲 = 100 €

                \033[%1$sC💵💵💵💵 = 200 €

                \033[%1$sC Each ⚪ =   2 €

                \033[57C══════════════════════
                \033[%1$sC   Ludopy Inc.
                \033[%1$sC   
                \033[%1$sCTime: %d
                """,positionMenu[1],spins,lesBoles.size(),System.currentTimeMillis()/1000,coins);
        cursorMoves.reset();
    } 

    /**
     * Imprimeix les boles que cauen pel pachinco (1 bola ).
     * @param lesBoles L'array de boles que estan a la maquina.
     */
    public static void boles(ArrayList<objects.Bola> lesBoles){
        int positionFirstPin[] = {20,25};
        cursorMoves.reset();

        //for (int i = 0; i < lesBoles.size(); i++) {
            if(!lesBoles.isEmpty() && lesBoles.get(0).stage >= 0 && lesBoles.get(0).stage <= 8){
                if (lesBoles.get(0).stage == 8) {
                    cursorMoves.moveXY((positionFirstPin[0]-(2*lesBoles.get(0).stage))+1, positionFirstPin[1]+(lesBoles.get(0).position*4));
                    System.out.print("⚪");
                }else{
                    cursorMoves.moveXY(positionFirstPin[0]-(2*lesBoles.get(0).stage), positionFirstPin[1]+(lesBoles.get(0).position*4));
                    System.out.print("⚪");
                }
            }
        //}
        cursorMoves.reset();
    }

    /**
     * Imprimeix l'estack de boles de la maquina
     * @param lesBoles L'array de les boles que hi ha a la maquina.
     * @param stackBolesPosition Posicio de la primera bola del stack
     */
    public static void stackBoles(ArrayList<objects.Bola> lesBoles,int stackBolesPosition[]){
        int alcadaStack = 0;
        for (int i = 0; i < lesBoles.size()-1; i++) {
            if(i >= 37){
                //stack full, do nothing
            }else if(i > 13){
                alcadaStack++;
                cursorMoves.reset();
                cursorMoves.moveXY(stackBolesPosition[0]+alcadaStack, stackBolesPosition[1]+(27));
                System.out.print("⚪");
            }else{
                cursorMoves.reset();
                cursorMoves.moveXY(stackBolesPosition[0], stackBolesPosition[1]+(i*2));
                System.out.print("⚪");
            }
            
        }
        cursorMoves.reset();
    }

    /**
     * Imprimeix les rodes i el seu resultat
     * @param lesRodes L'array de les rodes a mostrar.
     */
    public static void rodes(objects.Roda lesRodes[][]){
        int positionRodes[] = {44,3};
        String red = "\033[31m";
        String green = "\033[32m";
        String reset = "\033[0m";
        String color = "";

        for (int i = 0; i < lesRodes.length; i++) {
            for (int j = 0; j < lesRodes[0].length; j++) {
                cursorMoves.moveXY(positionRodes[0],positionRodes[1]);
                if(lesRodes[i][j].winner){
                    color = green;
                }else{
                    color = red;
                }
                switch (lesRodes[i][j].casellaGuanyadora) {
                    case 1:
                        System.out.printf("""
                            \033[%2$s
                            \033[1C\033[%1$sC╔════╩═══╗
                            \033[1C\033[%1$sC║        ║
                            \033[%1$sC═╣   💵  \033[1C╠═
                            \033[1C\033[%1$sC║        ║
                            \033[1C\033[%1$sC╚════╦═══╝\033[0m
                            """,positionRodes[1],color);
                        cursorMoves.reset();
                    break;
                    case 2:
                        System.out.printf("""
                            \033[%2$s
                            \033[1C\033[%1$sC╔════╩═══╗
                            \033[1C\033[%1$sC║        ║
                            \033[%1$sC═╣   💲  \033[1C╠═
                            \033[1C\033[%1$sC║        ║
                            \033[1C\033[%1$sC╚════╦═══╝\033[0m
                            """,positionRodes[1],color);
                        cursorMoves.reset();
                    break;
                    case 3:
                        System.out.printf("""
                            \033[%2$s
                            \033[1C\033[%1$sC╔════╩═══╗
                            \033[1C\033[%1$sC║        ║
                            \033[%1$sC═╣   💍  \033[1C╠═
                            \033[1C\033[%1$sC║        ║
                            \033[1C\033[%1$sC╚════╦═══╝\033[0m
                            """,positionRodes[1],color);
                        cursorMoves.reset();
                    break;
                    case 4:
                        System.out.printf("""
                            \033[%2$s
                            \033[1C\033[%1$sC╔════╩═══╗
                            \033[1C\033[%1$sC║        ║
                            \033[%1$sC═╣   🍒  \033[1C╠═
                            \033[1C\033[%1$sC║        ║
                            \033[1C\033[%1$sC╚════╦═══╝\033[0m
                            """,positionRodes[1],color);
                        cursorMoves.reset();
                    break;
                    case 5:
                        System.out.printf("""
                            \033[%2$s
                            \033[1C\033[%1$sC╔════╩═══╗
                            \033[1C\033[%1$sC║        ║
                            \033[%1$sC═╣   🍉  \033[1C╠═
                            \033[1C\033[%1$sC║        ║
                            \033[1C\033[%1$sC╚════╦═══╝\033[0m
                            """,positionRodes[1],color);
                        cursorMoves.reset();
                    break;
                    case 6:
                        System.out.printf("""
                            \033[%2$s
                            \033[1C\033[%1$sC╔════╩═══╗
                            \033[1C\033[%1$sC║        ║
                            \033[%1$sC═╣   ⚪  \033[1C╠═
                            \033[1C\033[%1$sC║        ║
                            \033[1C\033[%1$sC╚════╦═══╝\033[0m
                            """,positionRodes[1],color);
                        cursorMoves.reset();
                    break;
                    default:
                    System.out.printf("""
                            \033[%2$s
                            \033[%1$sC╔════════╗
                            \033[%1$sC║        ║
                            \033[%1$sC║   xx   ║
                            \033[%1$sC║        ║
                            \033[%1$sC╚════════╝\033[0m
                            """,positionRodes[1],color);
                cursorMoves.reset();

                }
                //positionRodes[0] = positionRodes[0];
                positionRodes[1] += 12;


            }
            positionRodes[0] -= 5 ;
            positionRodes[1] = 3 ;
        }
        cursorMoves.reset();
    }
}