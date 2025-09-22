package adriaborras_connect4;

import java.util.Scanner;

public class Connecta4 {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int columnes = 0;
        int files = 0;
        String j1 = "Adria";
        String j2 = "Naimus";
        String turnPlayer = "";
        String piecePlayer = "🟡";
        boolean gameOver = true;
        boolean restart = true;
        boolean turnPlayer1 = true;
        int playerPiece = 0;
        int numColumna = 0;
        int numSeleccionat = 0;
        int opcioMenu = 0;

        int lastMove[][] = new int[1][2];
        int winCount = 0;

        String playerNames[] = { "", "", "", "", "" };
        int playerScores[] = { 0, 0, 0, 0, 0 };

        while (restart == true) {
            // crea un espai on dibuixar
            System.out.print(
                    "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            drawTitle();
            drawScores(playerNames, playerScores);
            // mostra el menu
            System.out.print("""
                     \033[17F\033[33CMenu

                     \033[30C1- Juga
                     \033[30C2- Surt\033[40E\033[1F
                    """);

            System.out.print("\033[1F");
            do {
                System.out.print("Escull la opcio del menu >> ");
                if (keyboard.hasNextInt()) {
                    opcioMenu = keyboard.nextInt();
                    if (opcioMenu < 1 || opcioMenu > 2) {
                        System.out.println("\033[2FNumero fora de rang, Torna a provar!");
                    }
                } else {
                    System.out.println("\033[2FEt demanen un numero, Torna a provar!");
                    keyboard.nextLine();
                }
            } while (opcioMenu < 1 || opcioMenu > 2);

            switch (opcioMenu) {
                case 1:
                    System.out.print("\033[14F");
                    do {
                        System.out.print("\033[27CDe cuantes columnes vols el taulell? >> ");
                        columnes = keyboard.nextInt();
                        if (columnes < 4 || columnes > 9) {
                            System.out.println("\033[1F\033[27CNumero fora de rang, Torna a provar!\033[0J");
                        }
                    } while (columnes < 4 || columnes > 9);

                    do {
                        System.out.print("\033[27CDe cuantes files vols el taulell? >> ");
                        files = keyboard.nextInt();
                        if (files < 4 || files > 9) {
                            System.out.println("\033[1F\033[27CNumero fora de rang, Torna a provar!\033[0J");
                        }
                    } while (files < 4 || files > 9);

                    keyboard.nextLine();
                    System.out.print("\033[27CNom del jugador 1? >> ");
                    // System.out.println();
                    j1 = keyboard.nextLine();
                    System.out.print("\033[27CNom del jugador 2? >> ");
                    j2 = keyboard.nextLine();
                    gameOver = false;
                    System.out.print("\033[21F\033[0J\033[40E\033[1F");
                    break;
                case 2:
                    gameOver = true;
                    break;
            }

            int tauler[][] = new int[files][columnes];
            drawScores(playerNames, playerScores);
            drawTitle();
            drawGame(columnes, files, tauler);

            // game loop
            while (gameOver == false) {
                if (turnPlayer1 == true) {
                    playerPiece = 1;
                    turnPlayer = j1;
                    piecePlayer = "🟡";
                } else {
                    playerPiece = 2;
                    turnPlayer = j2;
                    piecePlayer = "🔴";
                }
                boolean placed = false;

                // tornar a fer sense continues o breaks.
                do {
                    // System.out.print("\033[2F\033[0J\033[1E");
                    System.out.print(
                            "\033[2F\033[1ETorn de:\033[34m " + turnPlayer + "\033[0m. Juga amb: " + piecePlayer
                                    + ". A quina columna vols ficar la fitxa? >> \033[0J");
                    // System.out.print("A quina columna vols ficar la fitxa? >> ");
                    numSeleccionat = keyboard.nextInt();

                    if (numSeleccionat < 1 || numSeleccionat > columnes) {
                        System.out.println("\033[2FNumero fora de rang, torna a probar.\033[0J\033[1E");
                        continue;
                    } else {
                        System.out.print("\033[2F\033[0J\033[2E");
                    }

                    numSeleccionat -= 1;

                    if (tauler[files - 1][numSeleccionat] != 0) {
                        System.out.println(
                                "\033[2FNo caben mes fitxes en asuqesta columna, torna a probar.\033[0J\033[1E");
                        continue;
                    } else {
                        System.out.print("\033[2F\033[0J\033[2E");
                    }

                    break;

                } while (true);

                numColumna = numSeleccionat;

                // comprovem quines caselles estan ocupades i posem a sobre
                for (int i = 0; i < files; i++) {
                    if (tauler[i][numColumna] == 0 && placed == false) {
                        tauler[i][numColumna] = playerPiece;
                        placed = true;
                        lastMove[0][0] = i;
                        lastMove[0][1] = numColumna;
                    }
                }
                // mostra quina es la ultima posicio jugada
                System.out.println("\033[24FUltim moviment:");
                System.out.println("Columna: " + (lastMove[0][1]));
                System.out.println("Fila: " + (lastMove[0][0]));
                System.out.print("\033[40E");

                // torna a mostrar el taulell de joc al posar fitxa
                drawGame(columnes, files, tauler);

                // Comprovem caselles per comprobar si hi ha 4 en linea
                // comprobar vertical
                winCount = 0;
                for (int i = 0; i < files; i++) {
                    if (tauler[i][numColumna] == playerPiece) {
                        winCount++;
                        if (winCount >= 4) {
                            System.out.print("\033[6FgameWon\033[40E");
                            gameOver = true;
                        }
                    } else {
                        winCount = 0;
                    }
                }
                winCount = 0;

                // comprovar horizontal
                for (int i = 0; i < columnes; i++) {
                    if (tauler[lastMove[0][0]][i] == playerPiece) {
                        winCount++;
                        if (winCount >= 4) {
                            System.out.print("\033[6FgameWon\033[40E");
                            gameOver = true;
                        }
                    } else {
                        winCount = 0;
                    }
                }















                // comprovar diagonal 1
                int columnaProvisional = lastMove[0][1];
                int filaProvisional = lastMove[0][0];
                // busquem el punt inicial de la diagonal (reduim fins a trobar algun borde)
                while (filaProvisional > 0 && columnaProvisional > 0) {
                    filaProvisional--;
                    columnaProvisional--;
                }

                System.out.print("\033[6Fbusca desde fila " + filaProvisional);
                System.out.print(" a columna " + columnaProvisional + "\033[40E");

                // if (gameOver == false) {
                winCount = 0;
                while (columnaProvisional < columnes - 1 && filaProvisional < files - 1 && gameOver == false) {
                    if (tauler[filaProvisional][columnaProvisional] == playerPiece) {
                        winCount++;
                        System.out.print(
                                "\033[8Fla casella es de:" + tauler[filaProvisional][columnaProvisional] + "\033[40E");
                        if (winCount >= 4) {
                            System.out.print("\033[6FgameWonlol\033[40E");
                            gameOver = true;
                            winCount = 0;
                        }
                    } else {
                        System.out.print("\033[5Fin a row:" + winCount + "\033[40E");
                        winCount = 0;
                    }
                    filaProvisional++;
                    columnaProvisional++;

                    System.out.print("\033[4FBuscant peçes del jugador");
                    System.out.print(playerPiece);
                    System.out.print(". contingut:" + tauler[filaProvisional][columnaProvisional]);
                    System.out.print(". buscat fins fila " + filaProvisional);
                    System.out.print(" a columna " + columnaProvisional + "\033[40E");
                }

                    // do{
                    //     if (tauler[filaProvisional][columnaProvisional] == playerPiece) {
                    //     winCount++;
                    //     System.out.print(
                    //             "\033[8Fla casella es de:" + tauler[filaProvisional][columnaProvisional] + "\033[40E");
                    //     if (winCount >= 4) {
                    //         System.out.print("\033[6FgameWonlol\033[40E");
                    //         gameOver = true;
                    //         winCount = 0;
                    //     }
                    // } else {
                    //     System.out.print("\033[5Fin a row:" + winCount + "\033[40E");
                    //     winCount = 0;
                    // }

                    // }while(columnaProvisional < columnes - 1 && filaProvisional < files - 1 && gameOver == false);






                 
















                // cuan el joc acaba afegeix guanyador a la llista
                if (gameOver == true) {
                    boolean nomAfegit = false;
                    for (int i = 0; i < playerNames.length - 1; i++) {
                        if (playerNames[i].equals("") && nomAfegit == false) {
                            playerNames[i] = turnPlayer;
                            nomAfegit = true;
                            playerScores[i]++;
                        } else if (playerNames[i].equals(turnPlayer) && nomAfegit == false) {
                            playerScores[i]++;
                            nomAfegit = true;
                        }
                    }
                    // torna a dibuixar la taula de puntuacio despres d'afegir el guanyador
                    drawScores(playerNames, playerScores);
                    // demana si vols tornar a jugar o tancar el programa.
                    System.out.print("""
                            \033[4Fvols tornar a jugar?
                            1- Si
                            2- No
                            """);
                    int seleccioReplay = keyboard.nextInt();
                    switch (seleccioReplay) {
                        case 1:
                            break;
                        case 2:
                            restart = false;
                            break;
                    }
                }
                // canvi de torn (comensara el jugador perdedor.)
                if (turnPlayer1 == true) {
                    turnPlayer1 = false;
                } else {
                    turnPlayer1 = true;
                }
            }
        }
    }

    // dibuixa el taulell

    static void drawGame(int columnes, int files, int tauler[][]) {
        char neutralc = '⚫'; // ⚫ U+26AB
        String j1c = "🟡";
        String j2c = "🔴";
        String boardPosition = "\033[40E\033[17F";

        System.out.print(boardPosition);

        // pinta el joc
        for (int i = files - 1; i >= 0; i--) {
            // pinta numeros a l'esquerra
            System.out.print("\033[24C" + (i + 1) + " ");
            for (int j = 0; j < columnes; j++) {
                if (tauler[i][j] == 0) {
                    System.out.print(neutralc);
                } else if (tauler[i][j] == 1) {
                    System.out.printf("%s", j1c);
                } else {
                    System.out.printf("%s", j2c);
                }
            }
            System.out.println();
        }
        // pinta numeros sota el taulell
        System.out.print("\033[26C");
        for (int i = 0; i < columnes; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        System.out.print("\033[40E");
    }

    // dibuixa el titol
    static void drawTitle() {
        String titlePosition = "\033[40E\033[30F";
        System.out.print(titlePosition);
        System.out.print("""
                \033[34m██████   ██████  ███    ██ ███    ██ ███████  ██████ ████████   ██   ██
                ██      ██    ██ ████   ██ ████   ██ ██      ██         ██      ██   ██
                ██      ██    ██ ██ ██  ██ ██ ██  ██ █████   ██         ██      ███████
                ██      ██    ██ ██  ██ ██ ██  ██ ██ ██      ██         ██           ██
                ██████   ██████  ██   ████ ██   ████ ███████  ██████    ██           ██  \033[0m
                """);
        System.out.print("\033[40E\033[1F");
    }

    // dibuixa puntuacions
    static void drawScores(String playerNames[], int playerScores[]) {
        String positionScores = "\033[40E\033[18F\033[5C";
        System.out.print(positionScores);
        System.out.printf("""
                Puntuacions
                \033[5C-----------
                \033[5C1- %s %d
                \033[5C2- %s %d
                \033[5C3- %s %d
                \033[5C4- %s %d
                \033[5C5- %s %d
                \033[40E""", playerNames[0], playerScores[0],
                playerNames[1], playerScores[1],
                playerNames[2], playerScores[2],
                playerNames[3], playerScores[3],
                playerNames[4], playerScores[4]);
    }
}
