package playground;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        boolean playing = true;
        int opcioEscollida = 0;
        int interactionPosition[] = { 25, 67 };
        int coins = 50;
        int insertCoinQuantity = 10;
        int spins = 0;
        int spinsPerCoin = 1;
        int boles = 0;
        int stackBolesPosition[] = {22,25};
        ArrayList<objects.Bola> lesBoles = new ArrayList<>();
        long currentTime = System.currentTimeMillis() / 1000;
        long now = currentTime;
        objects.Roda lesRodes[][] = new objects.Roda[4][4];
        boolean randomPin;
        int roundWinnings[] = new int[2]; //coins,boles
        boolean cashMoney = false;
        int jackpots[] = {200,100,50,10,20,3}; // 💵,💲,💍,🍒,🍉,⚪
        int red = 31;
        int green = 32;
        int colorFletxesStack = 31;

        

        printScreen.canvas();

        // Ompla array amb les rodes que crea
        for (int i = 0; i < lesRodes.length; i++) {
            for (int j = 0; j < lesRodes[0].length; j++) {
                lesRodes[i][j] = creaRoda();
            }
        }
        // mostra la pantalla inicial
        printScreen.Screen(lesRodes, coins, lesBoles, spins,stackBolesPosition,colorFletxesStack);

        // Juga!
        while (playing) {
            
            opcioEscollida = preguntaAccio(interactionPosition);
            //cashMoney = false;
            switch (opcioEscollida) {
                case 1:
                    if (coins >= insertCoinQuantity) {
                        spins += spinsPerCoin * insertCoinQuantity;
                        coins -= insertCoinQuantity;
                    }
                    break;
                case 2:
                    cashMoney = true;
                    break;
                case 3:
                    if (spins > 0) {
                        giraRodes(lesRodes);
                        roundWinnings = checkWins(lesRodes,jackpots);
                        spins--;
                        coins += roundWinnings[0];
                        boles += roundWinnings[1];
                    }
                    break;
                case 4:
                    // nothing, pass turn.
                    break;
                case 5:
                    // nothing, pass turn.
                    break;
                case 6:
                    playing = false;
                    cursorMoves.reset();
                    break;
                default:
                    // nothing, pass turn.
                    ;
            }

            // Afegeix les boles guanyades a la maquina. Millor for-loop?
            while (boles > 0) {
                lesBoles.add(new objects.Bola());
                boles--;
            }
            //si la bola te que baixar d'un pin, tria dreta o esquerra
            randomPin = random.nextBoolean();
            if (!lesBoles.isEmpty() && lesBoles.get(0).stage >= 2 && lesBoles.get(0).stage <= 6) {
                if (randomPin) {
                    lesBoles.get(0).position += 1;
                } else {
                    lesBoles.get(0).position -= 1;
                }
            }
            //si hi ha boles, mou la primera bola
            printScreen.Screen(lesRodes, coins, lesBoles, spins,stackBolesPosition,colorFletxesStack);
            if (!lesBoles.isEmpty()) {
                lesBoles.get(0).stage += 1;
                if (lesBoles.get(0).stage >= 9) {
                    //colorFletxesStack = red;
                    switch (lesBoles.get(0).position) {
                        case 1:
                        case -1:
                            coins += 2*2;
                            break;
                        case 3:
                        case -3:
                            coins += 2*8;
                            break;
                        case 5:
                        case -5:
                            coins += 2*16;
                            break;
                    }
                    lesBoles.remove(0);
                }else if(lesBoles.get(0).stage == 1){
                    colorFletxesStack = green;
                }else{
                    colorFletxesStack = red;
                }
            }

            if (cashMoney) {
                coins = cashMoney(coins);
                //printScreen.menu(coins, lesBoles, spins);
                cashMoney = false;
            }
        }
    }

    /**
     * Crea l'objecte roda
     * @return L'objecte roda.
     */
    public static objects.Roda creaRoda() {
        objects.Roda roda = new objects.Roda();
        return roda;
    }
    
    /**
     * Pregunta entre opcions del menu
     * @param interactionPosition Posicio on escriure la resposta del usuari.
     * @return retorna el valor escollit
    */
    public static  int preguntaAccio(int interactionPosition[]){
        cursorMoves.moveXY(interactionPosition[0], interactionPosition[1]);
        int opcioEscollida = dryUtils.triaOpcio(6);
        cursorMoves.reset();
        return opcioEscollida;
    }

    /**
     * Treu de la maquina les Monedes guanyades.
     * @param coins Quantitat de monedes que te la maquina.
     * @return  Les monedes que queden a la maquina. (0)
    */
    public static int cashMoney(int coins){
        
        int coinsPerLine = 50;
        int coinsPrinted = 0;
        int currentline = 1;
        for (int i = 0; i < coins; i++) {
            cursorMoves.moveXY(2+currentline, 2+coinsPrinted+currentline);
            System.out.print("🪙");
            cursorMoves.reset();
            coinsPrinted++;
            if(coinsPrinted == coinsPerLine){
                currentline++;
                coinsPrinted = 0;
                coinsPerLine = coinsPerLine-2;
            }
        }
        coins = 0;
        cursorMoves.reset();
        return coins;
    }

    
    /**
     * Gira les rodes per que donguin un resultat aleatori
     * @param lesRodes L'array amb les rodes a girar.
     */
    public static void giraRodes(objects.Roda lesRodes[][]) {
        Random random = new Random();
        for (int i = 0; i < lesRodes.length; i++) {
            for (int j = 0; j < lesRodes[0].length; j++) {
                lesRodes[i][j].randomWinner = random.nextInt(lesRodes[i][j].nombreCaselles);
                switch (lesRodes[i][j].randomWinner) {
                    case 1:
                        lesRodes[i][j].casellaGuanyadora = 1;//💵
                    break;
                    case 2:
                        lesRodes[i][j].casellaGuanyadora = 2;//💲
                    break;
                    case 3:
                        lesRodes[i][j].casellaGuanyadora = 3;//💍
                    break;
                    case 4:
                    case 5:
                        lesRodes[i][j].casellaGuanyadora = 4;//🍒
                    break;
                    case 6:
                    case 7:
                    case 8:
                        lesRodes[i][j].casellaGuanyadora = 5; //🍉
                    break;
                    case 0:
                    case 9:
                    case 10:
                    case 11:
                        lesRodes[i][j].casellaGuanyadora = 6; //⚪
                    break;
                    default:
                   
                cursorMoves.reset();
                }
            }
        }
    }

    // no se si retorno l'array correctament. O passar array roundWins amb String void, i
    // modificar array per que persisteix?
    public static int[] checkWins(objects.Roda lesRodes[][],int jackpots[]) {
        int roundWinnings[] = new int[2]; // coins,boles
        int prizeLenght = 4;
        int winToCheck = 0;
        int prizeCounter = prizeLenght;

        //check horizontal
        for (int i = 0; i < lesRodes.length; i++) {
            winToCheck = lesRodes[i][0].casellaGuanyadora;
            for (int j = 0; j < lesRodes[0].length; j++) {
                lesRodes[i][j].winner = false;
                if (lesRodes[i][j].casellaGuanyadora == winToCheck) {
                    prizeCounter--;
                    cursorMoves.reset();
                }
            }
            if (prizeCounter == 0) {
                //marca les caselles de la linea com a guanyadores
                for (int k = 0; k < lesRodes[0].length; k++){
                    lesRodes[i][k].winner = true;
                }
                //Quin premi ha guanyat?
                if (winToCheck == 6) {
                    roundWinnings[1] = jackpots[winToCheck-1];
                }else{
                roundWinnings[0] += jackpots[winToCheck-1];
                }
                cursorMoves.reset();
            }
            prizeCounter = prizeLenght;
        }

        //check vertical
        for (int j = 0; j < lesRodes[0].length; j++) {
            for (int i = 0; i < lesRodes.length; i++) {
                winToCheck = lesRodes[0][j].casellaGuanyadora;
                if (lesRodes[i][j].casellaGuanyadora == winToCheck) {
                    prizeCounter--;
                    cursorMoves.reset();
                }
            }
            if (prizeCounter == 0) {
                for (int k = 0; k < lesRodes.length; k++){
                    lesRodes[k][j].winner = true;
                }
                if (winToCheck == 6) {
                    roundWinnings[1] = jackpots[winToCheck-1];
                }else{
                roundWinnings[0] += jackpots[winToCheck-1];
                }
                cursorMoves.reset();
            }
            prizeCounter = prizeLenght;
        }
        return roundWinnings;
    }

}