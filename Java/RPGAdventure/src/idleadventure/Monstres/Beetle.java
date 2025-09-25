package idleadventure.Monstres;

import idleadventure.Personatges.Personatge;
import idleadventure.Utils.cursorMoves;

public class Beetle extends Monstre {

    
    public Beetle() {
        super.imatge = "🪲 ";

        super.nom = "Beetle";
        super.vida = 3;
        super.mana = 0;
        super.stamina = 0;

        super.str = 1;
        super.agi = 0;
        super.intel = 2;
        super.dex = 0;
        super.luck = 0;
        super.expGiven = 1;
    }

    @Override
    public void interact(Personatge hero){
        if(!super.interacted){
                if(hero.getIntel()>= this.intel){
                    cursorMoves.moveXY(7,3);
                    System.out.println("You know a bit more about it");
                    super.interacted = true;
                }else{
                    cursorMoves.moveXY(7,3);
                    System.out.println("It's just a bug");  
                }
        }else{
            cursorMoves.moveXY(7,3);
            System.out.println("All already known about it");
        }
    };

    @Override
    public void talk(){
        cursorMoves.moveXY(7,3);
        System.out.println("It's a bug... It can't talk.");
    };

    
}
