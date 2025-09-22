package idleadventure.Utils;

import java.util.Scanner;

/*Aquest utils te els seguents metodes:
 * 
 * demanaInt()
 * demanaInt(int tipus)
 * demanaDouble()
 * demanaString()
 * pregunta(String text, String afirmatiu, String negatiu)
 * fanParella(int x,int y,int z)
 * calculaBonificacio(double beneficiNegoci)
 * demanaEdat()
 * triaOpcio(int quantitatOpcions)
 * arrel(int num)
 * sumaDos()
 * restaDos()
 * multiplicarDos()
 * dividirDos()
 * dividir(double num1,double num2)
 * potenciaDos()
 * sumaIndex()
 */

public class dryUtils {

    /**
     * Demana un nombre Int al usuari.
     * 
     * -Valida que sigui un numero Int.
     * 
     * @return El nombre intrduit per l'usuari.
     */

    public static int demanaInt() {
        Scanner scanner = new Scanner(System.in);
        int numeroDemanat = 0;
        boolean valid = false;

        do {
            //System.out.print("Introdueix un numero Int >> ");
            if (scanner.hasNextInt()) {
                numeroDemanat = scanner.nextInt();
                valid = true;
            } else {
                //System.out.println("No es un numero valid.");
            }
            scanner.nextLine();
        } while (valid == false);
        return numeroDemanat;
    }


    /**
     * Demana un nombre int entre 2 nombres
     * @param min Nombre int, minim
     * @param max Nombre int, maxim
     * @return Int, nombre escollit per l'usuari.
     */
    public static int demanaInt(int min, int max){
        int numeroDemanat = 0;
        boolean valid = false;
        
        while (!valid) { 
            System.out.println("Introdueix un nombre entre: " + min + " i " + max);
            numeroDemanat = dryUtils.demanaInt();  
            if (numeroDemanat > min && numeroDemanat < max) {
                valid = true;
            }else{
                System.out.println("El nombre no esta entre els 2 valors demanats.");
            }
        }
        return numeroDemanat;
    }


    /**
     * Demana un nombre double al usuari
     * @return Double. Nombre introduit per l'usuari.
     */
    public static double demanaDouble() {
        Scanner scanner = new Scanner(System.in);
        double num = 0;
        boolean valid = false;
  
        do {
           System.out.print("Introdueix un numero Double >> ");
           if (scanner.hasNextDouble()) {
              num = scanner.nextDouble();
              valid = true;
           } else {
              System.out.println("No es un numero valid.");
              scanner.nextLine();
           }
        } while(!valid);
  
        return num;
    }


    /**
     * 
     * @param min
     * @param max
     * @return
     */
    public static double demanaDouble(int min, int max){
        double numeroDemanat = 0;
        boolean valid = false;

        while (!valid) { 
            System.out.println("Introdueix un nombre entre: " + min + " i " + max);
            numeroDemanat = dryUtils.demanaDouble();  
            if (numeroDemanat > min && numeroDemanat < max) {
                valid = true;
            }else{
                System.out.println("El nombre no esta entre els 2 valors demanats.");
            }
        }
        return numeroDemanat;
    }

    /**
     * Demana un String al usuari.
     * @return String. La frase introduida per l'usuari
     */
    public static String demanaString() {
        Scanner teclat = new Scanner(System.in);
  
        String frase;
        do {
           System.out.print("Introdueix una frase >> ");
           frase = teclat.nextLine();
           if (frase.length() == 0) {
              System.out.println("No es una frase valida.");
           }
        } while(frase.length() == 0);
  
        return frase;
    }

    public static String demanaChar() {
        Scanner teclat = new Scanner(System.in);
  
        String frase;
        do {
           //System.out.print("Introdueix una opcio >> ");
           frase = teclat.nextLine().toLowerCase();
           if (frase.length() == 0 || frase.length() >= 2 ) {
              //System.out.print("No es una opcio valida.");
           }
        } while(frase.length() == 0 || frase.length() >= 2 );
  
        return frase;
    }




/**
 * Demana al usuari un nombre int depenent si el vols positiu o negatiu
 * @param tipus String "+"/"-" per indicar si el vols positiu o negatiu
 * @return int del nombre demanat a l'usuari
 */
    public static int demanaInt(String tipus) {
        Scanner scanner = new Scanner(System.in);
        int numeroDemanat = 0;
        boolean valid = false;
        do {
            if(tipus.equals("+")){
                //System.out.print("Introdueix un numero Int positiu >> ");
                if (scanner.hasNextInt() ) {
                    numeroDemanat = scanner.nextInt();
                    
                    if(numeroDemanat >= 0){
                        valid = true;
                    }else {
                        //System.out.println("No es un numero positiu.");
                    }
                    
                } else {
                    //System.out.println("No es un numero valid.");
                }
                scanner.nextLine();
            }else if(tipus.equals("-")){
                //System.out.print("Introdueix un numero Int negatiu >> ");
                if (scanner.hasNextInt() ) {
                    numeroDemanat = scanner.nextInt();
                    if(numeroDemanat < 0){
                        valid = true;
                    }else {
                        //System.out.println("No es un numero negatiu.");
                    }
                   
                } else {
                    //System.out.println("No es un numero valid.");
                }
                scanner.nextLine();
            }
        } while (valid == false);
        return numeroDemanat;
    }



    
    /**
     * Demana una pregunta i 2 opcions de resposta (String) i retorna la seleccio escollida per l'usuari.
     * @param text Pregunta a fer al usuari.
     * @param afirmatiu Opcio afirmativa desitjada
     * @param negatiu   Opcio negativa desitjada
     * @return retorna l'opcio escollida per l'usuari.
     */
    public static String pregunta(String text, String afirmatiu, String negatiu) {
        Scanner teclat = new Scanner(System.in);
        String resposta = "";
        boolean caracterValid = false;
        
        do {
            System.out.print(text + afirmatiu + "/"+ negatiu + " >> ");
            String input = teclat.nextLine().toLowerCase(); 
        
            if (input.equals(afirmatiu) || input.equals(negatiu)) {
                resposta = input; 
                caracterValid = true; 
            } else {
                System.out.println("No es una seleccio valida."); 
            }
        } while (caracterValid == false);
        return resposta;
    }


    /**
     * Divideix dos nombres double i retorna el resultat.
     * @param num1  Nombre a dividir.
     * @param num2  Divisor.
     * @return Resultat de l'operacio. (Double)
     */
    public static double dividir(double num1,double num2){
        double resultat = 0;
        if(num2 == 0){
            System.out.println("Divisio impossible");
        }
        else{
            //System.out.println(num1/num2);
            resultat = num1/num2;
        }
        return resultat;
    }


    /**
     * Calcula l'arrel cuadrada d'un nombre
     * @param num Double, nombre a calcular la seva arrel.
     * @return double, resultat de l'operacio.
     */
    public static double arrel(int num) {
        double resultat = Math.sqrt(num);
        if(resultat<0){
            resultat = -1;
        }
        return resultat;
    }


    /**
     * Comprova si 2 dels 3 nombres fan parella.
     * @param x int numero a comprovar
     * @param y int numero a comprovar
     * @param z int numero a comprovar
     * @return boolean, si alguna parella es igual o no.
     */
    public static boolean fanParella(int x,int y,int z){
        boolean fanParella = false;
        if(x==y || x==z || y==z){
            fanParella = true;
        }
        return fanParella;
    }

    /**
     * Calcula la comissio de les vendes d'un exercici en concret
     * @param beneficiNegoci El benefici de la transaccio.
     * @return Double, valor de la comissio de la transaccio.
     */
    public static double calculaBonificacio(double beneficiNegoci){
        double comissio = 0;
        if(beneficiNegoci<20000){
            comissio += 7000 + (beneficiNegoci*0.02);
        }
        else if(beneficiNegoci >= 20000 && beneficiNegoci <= 50000){
            comissio += 15000 + (beneficiNegoci*0.03);
        }
        else if(beneficiNegoci > 50000){
            comissio += 20000 + (beneficiNegoci*0.12);
        }
        return comissio;
    } 

    /**
     * Demana la edat al usuari
     * @return Int positiu, mes petit de 120.
     */
    public static int demanaEdat(){
        int edat = 0;
        boolean esCorrecte = false;
        while (!esCorrecte) { 
            edat = dryUtils.demanaInt("+");
            if(edat<120){
                esCorrecte = true;
            }else{
                System.out.println("Ja estaries mort, segur?");
            }
        }
        return edat;
    }

    /**
     * Demana al usuari la selecio d'una entre varies opcions.
     * @param quantitatOpcions Numero d'opcions a escollir
     * @return int. Numero de la opcio escollida.
     */
    public static int triaOpcio(int quantitatOpcions){
        int opcioTriada = 0; 
        boolean opcioValida = false;

        while (!opcioValida) {
            opcioTriada = dryUtils.demanaInt("+");
            if(opcioTriada > 0 && opcioTriada <= quantitatOpcions){
                opcioValida = true;
            }else{
                //System.out.println("Opcio no valida.");
            }
        }
        return opcioTriada;
        
    }

    /**
     * Demana 2 nombres al usuari i calcula la seva suma.
     * @return Double. Resultat de la operacio.
     */
    public static double sumaDos(){
        double resultat;
        System.out.println("Primer nombre a sumar: ");
        int num1 = dryUtils.demanaInt();
        System.out.println("Segon nombre a sumar: ");
        int num2 = dryUtils.demanaInt();
        resultat = num1+num2;
        return resultat;
    }

    /**
     * Demana 2 nombres al usuari i calcula la seva resta
     * @return Double. Resultat de la operacio.
     */
    public static double restaDos(){
        double resultat;
        System.out.println("Primer nombre a restar: ");
        int num1 = dryUtils.demanaInt();
        System.out.println("Segon nombre a restar: ");
        int num2 = dryUtils.demanaInt();
        resultat = num1-num2;
        return resultat;
    }

    /**
     * Demana 2 nombres al usuari i calcula la seva multiplicacio.
     * @return Double. Resultat de la operacio.
     */
    public static double multiplicarDos(){
        double resultat;
        System.out.println("Primer nombre a multiplicar: ");
        int num1 = dryUtils.demanaInt();
        System.out.println("Segon nombre a multiplicar: ");
        int num2 = dryUtils.demanaInt();
        resultat = num1*num2;
        return resultat;
    }
 /**
  * Demana 2 nombres al usuari i calcula la seva divisio.
  * @return Double resultat de la operacio.
  */
    public static double dividirDos(){
        double resultat;
        System.out.println("Primer nombre a dividir: ");
        int num1 = dryUtils.demanaInt();
        System.out.println("Segon nombre a dividir: ");
        int num2 = dryUtils.demanaInt();
        resultat = num1*num2;
        return resultat;
    }

    /**
     * Demana 2 nombres al usuari i calcula la potencia.
     * @return Double resultat de la operacio.
     */
    public static double potenciaDos(){
        double resultat;
        System.out.println("Primer nombre a elevar: ");
        int num1 = dryUtils.demanaInt();
        System.out.println("Segon nombre, la potencia: ");
        int num2 = dryUtils.demanaInt();
        resultat = Math.pow(num1, num2);
        return resultat;
    }


    /**
     * Demana un String al usuari i suma els index del String demanat.
     * @return Int suma dels index de totes les lletres
     */
    public static int sumaIndex(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entra la paraula a sumar els index >> ");

        String paraula = scanner.nextLine().toLowerCase().replace(" ", "");
        int sumaIndex = 0;
        
        for (int i = 0; i < paraula.length(); i++) {
            int indexLletra = (int)paraula.charAt(i) - (int)'a' + 1;
            sumaIndex += indexLletra;
        }
        return sumaIndex;
    }


    //adnan
    /**
     * Busca un valor int en un array de 2 dimensions
     * @param array Array a buscar
     * @param valor Valor a buscar
     * @return
     */
    // public static int[] buscarValor(int[][] array, int valor) {
    //     for (int i = 0; i < array.length; i++) {
    //         for (int j = 0; j < array[i].length; j++) {
    //             if (array[i][j] == valor) {
    //                 return new int[]{i, j};
    //             }
    //         }
    //     }
    //     return new int[]{-1, -1};
    // }

    

    public static int[] buscarValor(int array[][], int valor) {
        int valorIgual[] = new int[2];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == valor) {
                    valorIgual[0] = array[i][j];
                    valorIgual[1] = array[i][j]; 
                }
            }
        }
        return valorIgual;
    }

   



}
