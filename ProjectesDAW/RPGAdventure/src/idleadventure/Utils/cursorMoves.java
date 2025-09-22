package idleadventure.Utils;

public class cursorMoves {

    /**
     * Mou la posicio N linies cap amunt
     * @param n Nombre de linies a moure cap amunt.
     */
    public static void moveup(int n){
        String moveUp = ("\033["+ n + "F");
        System.out.print(moveUp);
    }
    
    /**
     * Mou el cursor a una posicio, per poder imprimir caracters
     * @param x Posicio d'avaix(0) a dalt(max).
     * @param y Posicio d'esquerra(0) a dreta(max).
     */
    public static void moveXY(int x,int y){
        cursorMoves.reset();
        String moveUp = ("\033["+ x + "F");
        String moveRight = ("\033[" + y + "C");
        System.out.print(moveUp + moveRight);
    }

    public static void mapPosition(){
        System.out.print("\033[42F");
    }
    
    public static void reset(){
        System.out.print("\033[100E"); //\033[2K
    }

 
}
