package Games;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BattleShips {
    public static void main(String[] args) {
         
        int screenWide = 30;
        int screenHeight = 50;
        int shipNumber = 0;
        boolean shipsPlaced = false;
        boolean placingShips = true;
        int ships[] = {2,3,3,4,5,1};
        char inputChar = ' ';
        boolean isVertical = false;
        int currentPosition[] = {0,0};
        Random RandomNumber = new Random();
        int ufoPosition = 0;
        int colorNumber = 0;
        int dialogNumber = 0;
        int tilesWithShip[] = {-1};
        int tilesHit[] = {-1};
        boolean isGuessing = false;
        int ship1[] = new int[2];
        int ship2[] = new int[3];
        int ship3[] = new int[3];
        int ship4[] = new int[4];
        int ship5[] = new int[5];


        //draw empty screen
        for (int i = 0; i < screenHeight; i++) {
            for (int j = 0; j < screenWide; j++) {
                System.out.print("  ");
                
            }
            System.out.println();
        }

        // ufoPosition = RandomNumber.nextInt(100);
        // System.out.print(ufoPosition);


        //draw game sections
        
        drawMenu(inputChar);
        drawLeftMenu();
        drawDialog(dialogNumber);
        drawSea(currentPosition,isVertical,ships[0],tilesWithShip,isGuessing,tilesHit);
        colorNumber = RandomNumber.nextInt(7)+31;
        drawBorders(colorNumber);
        drawTitle(colorNumber);

        //start game loop
        
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        while(shipNumber < ships.length && shipsPlaced == false){
            //placingShips = true;
            while(placingShips == true){
                
                /*Comprova que no es deixi buit l'input*/
                // while(input.isEmpty()){
                //     System.out.print("\033[1F");
                //     input = keyboard.nextLine();
                    
                // }
                // inputChar = input.charAt(0);
                // input = "";

                /*variant mes elegant (per que no savem cuantes vegades)*/
                do {
                    System.out.print("\033[1F");
                    input = keyboard.nextLine();
                    if (input.isEmpty()) {
                    }
                } while (input.isEmpty());
                inputChar = input.charAt(0);

                /* simple input: do not use ( index error if empty) */
                // System.out.print("\033[1F");
                // String input = keyboard.nextLine();
                // inputChar = input.charAt(0);

                
                if(inputChar == 'r'){
                    if(isVertical == false){
                        isVertical = true;
                    }
                    else {
                        isVertical = false;
                    }
                }
                if(inputChar == 's'){
                    currentPosition[0]++;
                    if(currentPosition[0] >=9-ships[shipNumber]+1 && isVertical == true){
                        currentPosition[0] = 9-ships[shipNumber]+1;
                    }
                    else if(currentPosition[0] >=9 && isVertical == false){
                        currentPosition[0] = 9;
                    }
                }
                else if(inputChar == 'd'){
                    currentPosition[1]++;
                    if(currentPosition[1] >=9-ships[shipNumber]+1 && isVertical == false){
                        currentPosition[1] = 9-ships[shipNumber]+1;
                    }
                    else if(currentPosition[1] >=9 && isVertical == true){
                        currentPosition[1] = 9;
                    }
                }
                else if(inputChar == 'w'){
                    currentPosition[0]--;
                    if(currentPosition[0] <=0){
                        currentPosition[0] = 0;
                    }
                }
                else if(inputChar == 'a'){
                    currentPosition[1]--;
                    if(currentPosition[1] <=0){
                        currentPosition[1] = 0;
                    }
                }
                else if (inputChar == 'e' && !(shipNumber >= 5)){
                    //save in array
                    tilesWithShip = Arrays.copyOf(tilesWithShip, tilesWithShip.length+1);
                    tilesWithShip[tilesWithShip.length-1] = Integer.parseInt(currentPosition[0]+""+currentPosition[1]);

                    //falta afegir les caselles de posicio dels vaixells al array de cada vaixell.
                    //si es el primer vaixell afegeix la posicio al array del vaixell
                    if(shipNumber == 0){
                    ship1[0] = Integer.parseInt(currentPosition[0]+""+currentPosition[1]);
                    }

                    if(isVertical == false){
                        for (int i = 0; i < ships[shipNumber]; i++) {
                            tilesWithShip = Arrays.copyOf(tilesWithShip, tilesWithShip.length+1);
                            tilesWithShip[tilesWithShip.length-1] = Integer.parseInt(currentPosition[0]+""+(currentPosition[1]+i));
                            ship1[1] = Integer.parseInt(currentPosition[0]+""+currentPosition[1]+i);


                        }
                        if(shipNumber >= ships.length-1){
                            shipsPlaced = true;
                        }
                    }
                    if(isVertical == true){
                        for (int i = 0; i < ships[shipNumber]; i++) {
                            tilesWithShip = Arrays.copyOf(tilesWithShip, tilesWithShip.length+1);
                            tilesWithShip[tilesWithShip.length-1] = Integer.parseInt((currentPosition[0]+i)+""+(currentPosition[1]));
                        }
                        if(shipNumber >= ships.length-1){
                            shipsPlaced = true;
                        }
                    }
                    shipNumber++;
                    dialogNumber++;
                    drawDialog(dialogNumber);
                    
                }
                else if (inputChar == 'e' && isGuessing == true){
                    tilesHit = Arrays.copyOf(tilesHit, tilesHit.length+1);
                    tilesHit[tilesHit.length-1] = Integer.parseInt(currentPosition[0]+""+currentPosition[1]);
                    /*falta comprobar si toca i canviar text */
                }
                else if (inputChar == 'c'){
                    colorNumber = RandomNumber.nextInt(7)+31;
                    //System.out.print(colorNumber);
                }
                if (shipNumber == 5){
                    isGuessing = true;
                    
                }
                
                drawSea(currentPosition,isVertical,ships[shipNumber],tilesWithShip,isGuessing,tilesHit);
                drawMenu(inputChar);
                drawBorders(colorNumber);
                drawTitle(colorNumber);
                
            }
                        
        }
        //no queden ships a posar
        //fes: 
        //System.out.print(Arrays.toString(tilesWithShip));
        
    }


    static void drawSea(int currentPosition[],boolean isVertical,int ships, int tilesWithShip[],boolean isGuessing,int tilesHit[]) {

        int seaWide = 10;
        int seaHeight = 10; 
        String seaPosition = "\033[26F\033[20C";
        boolean hasShip = false;
        boolean isHit = false;
        
        System.out.print(seaPosition);
        for (int i = 0; i < seaHeight; i++) {
            for (int j = 0; j < seaWide; j++) {
                //checks for array of ocuped tiles
                hasShip = false;
                isHit = false;
                for (int k = 0; k < tilesWithShip.length; k++) {
                    if (tilesWithShip[k] == Integer.parseInt(i + "" + j)) {
                        hasShip = true;
                    } 
                }
                for (int l = 0; l < tilesHit.length; l++) {
                    if (tilesHit[l] == Integer.parseInt(i + "" + j)) {
                        isHit = true;
                    } 
                }

                if(isGuessing == true && !(currentPosition[0] == i && currentPosition[1] == j) && !(isHit== true) ){
                    System.out.print("🟦");
                }
                else if(isHit == true && hasShip == true){
                    if(currentPosition[0] == i && currentPosition[1] == j ){
                        System.out.print("\033[5m🔥\033[0m");
                    }
                    else{
                        System.out.print("🔥");
                    }
                }
                else if(isHit == true ){
                    if(currentPosition[0] == i && currentPosition[1] == j ){
                        System.out.print("\033[5m🌀\033[0m");
                    }
                    else{
                        System.out.print("🌀");                    
                    }
                    
                }
                else if(hasShip == true && isGuessing == false){
                    if(currentPosition[0] == i && currentPosition[1] == j ){
                        System.out.print("\033[5m🚢\033[0m");
                    }
                    else{
                        System.out.print("🚢");                    
                    }
                    
                }
                else if(currentPosition[0] == i && currentPosition[1] == j ){
                    if(isGuessing==true){
                        System.out.print("🎯");
                    }
                    else{
                        System.out.print("🟩");
                    }
                }
                else if(isVertical == false){
                    if(ships == 2 && currentPosition[0] == i && currentPosition[1] == j-1 && j < seaWide){
                        System.out.print("🟩");
                    }
                    else if(ships == 3 && currentPosition[0] == i &&  j < seaWide && (currentPosition[1] == j-1 || currentPosition[1] == j-2) ){
                        System.out.print("🟩");
                    }
                    else if(ships == 4 && currentPosition[0] == i &&  j < seaWide && (currentPosition[1] == j-1 || currentPosition[1] == j-2 || currentPosition[1] == j-3) ){
                        System.out.print("🟩");
                    }
                    else if(ships == 5 && currentPosition[0] == i &&  j < seaWide && (currentPosition[1] == j-1 || currentPosition[1] == j-2 || currentPosition[1] == j-3 || currentPosition[1] == j-4) ){
                        System.out.print("🟩");
                    }
                    else{
                        System.out.print("🟦");
                    }
                 }
                else if(isVertical == true){
                    if(ships == 2 && currentPosition[1] == j && currentPosition[0] == i-1 && i < seaHeight){
                        System.out.print("🟩");
                    }
                    else if(ships == 3 && currentPosition[1] == j &&  i < seaHeight && (currentPosition[0] == i-1 || currentPosition[0] == i-2) ){
                        System.out.print("🟩");
                    }
                    else if(ships == 4 && currentPosition[1] == j &&  i < seaHeight && (currentPosition[0] == i-1 || currentPosition[0] == i-2 || currentPosition[0] == i-3) ){
                        System.out.print("🟩");
                    }
                    else if(ships == 5 && currentPosition[1] == j &&  i < seaHeight && (currentPosition[0] == i-1 || currentPosition[0] == i-2 || currentPosition[0] == i-3 || currentPosition[0] == i-4) ){
                        System.out.print("🟩");
                    }
                    else{
                        System.out.print("🟦");
                    }
                }
            }
            System.out.print("\033[1E\033[20C");
        }
        System.out.print("\033[40E");
        //System.out.print("\033[20Csdsdsd" + Arrays.toString(tilesWithShip2));
    }


    static void drawMenu(char inputChar){
        String menuPosition = "\033[8F\033[4C\033[34m";
        System.out.print(menuPosition);
        if(inputChar == ' '){
            System.out.print("""
            Inputs:
            \033[4C                 WASD - Move
            \033[4C      ˄             E - Confirm action.
            \033[4C    ˂   ˃           R - Rotate               
            \033[4C      ˅             C - Color (Random)
            """);
        }
        if(inputChar == 'w'){
            System.out.print("""
            Inputs:
            \033[4C                 WASD - Move
            \033[4C      \033[31m˄\033[34m             E - Confirm action.
            \033[4C    ˂   ˃           R - Rotate
            \033[4C      ˅             C - Color (Random)
            """);
        }
        if(inputChar == 's'){
            System.out.print("""
            Inputs:
            \033[4C                 WASD - Move
            \033[4C      ˄             E - Confirm action.
            \033[4C    ˂   ˃           R - Rotate
            \033[4C      \033[31m˅\033[34m             C - Color (Random)
            """);
        }
        if(inputChar == 'd'){
            System.out.print("""
            Inputs:
            \033[4C                 WASD - Move
            \033[4C      ˄             E - Confirm action.
            \033[4C    ˂   \033[31m˃\033[34m           R - Rotate
            \033[4C      ˅             C - Color (Random)
            """);
        }
        if(inputChar == 'a'){
            System.out.print("""
            Inputs:
            \033[4C                 WASD - Move
            \033[4C      ˄             E - Confirm action.
            \033[4C    \033[31m˂\033[34m   ˃           R - Rotate
            \033[4C      ˅             C - Color (Random)
            """);
        }
        


        System.out.print("\033[40E\033[0m");
    }

    static void drawLeftMenu(){

        String leftMenuPosition = "\033[28F\033[4C";


        System.out.print(leftMenuPosition);
        System.out.print("""
           Ships:

        \033[4C 🚢🚢     

        \033[4C 🚢🚢🚢

        \033[4C 🚢🚢🚢

        \033[4C 🚢🚢🚢🚢

        \033[4C 🚢🚢🚢🚢🚢
        """);


        System.out.print("\033[40E");
        
    }

    static void drawDialog(int dialogNumber){

        String dialogPosition = "\033[13F\033[15C\033[34m";
        String dialogToShow = " ";

        switch(dialogNumber){
            case 0:
                dialogToShow = "Place a 2x1 ship\033[0K";
            break;
            case 1:
                dialogToShow = "Place a 3x1 ship\033[0K";
            break;
            case 2:
                dialogToShow = "Place another 3x1 ship\033[0K";
            break;
            case 3:
                dialogToShow = "Place a 4x1 ship\033[0K";
            break;
            case 4:
                dialogToShow = "Last one, place a 5x1 ship\033[0K";
            break;
            case 5:
                dialogToShow = "No more ships to place.\033[0K\n\033[25CL'ets go!!\033[0K";
            break;
            case 6:
                dialogToShow = "pfff\033[0K";
            break;
        }
        System.out.print(dialogPosition);
        System.out.print(dialogToShow);


        System.out.print("\033[40E");
    }

    static void drawBorders(int colorNumber){
        /*Draw exterior border*/
        System.out.printf("\033[%dm",colorNumber);
        String borderPosition = "\033[1F";
        System.out.print(borderPosition);
        for (int i = 0; i < 35; i++) {
            System.out.print("\033[1D\033[1F");
            if(i == 35-1 ){
                System.out.print("╔");
            }
            else if(i == 0){
                System.out.print("╚");
            }
            else{
                System.out.print("║");
            }
        }
        for (int i = 0; i < 59; i++) {
            System.out.print("═");
        }
        System.out.print("\033[40E\033[2F\033[1C");
        for (int i = 0; i < 59; i++) {
            System.out.print("═");
        }
        System.out.print("\033[40E\033[1F\033[60C");
        for (int i = 0; i < 35; i++) {
            System.out.print("\033[1D\033[1F\033[60C");
            if(i == 35-1 ){
                System.out.print("╗");
            }
            else if(i == 0){
                System.out.print("╝");
            }
            else{
                System.out.print("║");
            }

            /*Draw sea border*/
        }
        System.out.print("\033[40E\033[16F\033[18C");
        for (int i = 0; i < 12; i++) {
            if(i == 12-1 ){
                System.out.print("╔");
            }
            else if(i == 0){
                System.out.print("╚");
            }
            else{
                System.out.print("║");
            }
            System.out.print("\033[1D\033[1F\033[18C");
        }
        System.out.print("\033[40E\033[16F\033[41C");
        for (int i = 0; i < 12; i++) {
            if(i == 12-1 ){
                System.out.print("╗");
            }
            else if(i == 0){
                System.out.print("╝");
            }
            else{
                System.out.print("║");
            }
            System.out.print("\033[1D\033[1F\033[41C");
        }
        System.out.print("\033[40E\033[27F\033[19C");
        for (int i = 0; i < 22; i++) {
            System.out.print("═");        
        }

        System.out.print("\033[40E\033[16F");
        for (int i = 0; i < 61; i++) {
            if(i == 18 ){
                System.out.print("╩");
            }
            else if(i == 41 ){
                System.out.print("╩");
            }
            else if(i == 60 ){
                System.out.print("╣");
            }
            else if(i == 0){
                System.out.print("╠");
            }
            else{
                System.out.print("═");
            }
            //System.out.print("═");        
        }
        System.out.print("\033[40E");
        
    }

    static void drawTitle(int colorNumber){

        String titlePosition = "\033[32F\033[10C";

         /*This is a mindfuck!  
         -Si mous a la posicio amb ANSI codes i escrius el color, apareix color fort.
         -Si fas un espai despres d'escriure el color(avans dels caracters a pintar) pintara fluix (el normal).
         -No tot
        \033[%dm █▄▄ ▄▀█ ▀█▀ ▀█▀ █   █▀▀ █▀ █ █ █ █▀█ █▀\033[0ms els colors tenen aquesta propietat.
          */
        System.out.print(titlePosition);
        System.out.print("""
        \033[%dm █▄▄ ▄▀█ ▀█▀ ▀█▀ █   █▀▀ █▀ █ █ █ █▀█ █▀\033[0m
        \033[%1$dm\033[11C█▄█ █▀█  █   █  █▄▄ ██▄ ▄█ █▀█ █ █▀▀ ▄█\033[0m
                   
        """.formatted(colorNumber));
        System.out.print("\033[40E");
    }
}

//to do:
//rotar al posar vaixells surt de la pantalla
// falta comprobar si al posar un vaixell ja n'hi ha un a la casella
// marcar vaixells destruits


//vero:
// 🛸 et digi tan abduit els alienigenas game over i si fallas clicar la casella on samagan els aliens pers.
//En una casella del mar aleatoria, esta amagat un alien que et diu: Els aliens t'han abduit! GAME OVER!    

    