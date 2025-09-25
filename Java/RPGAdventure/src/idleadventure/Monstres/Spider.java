package idleadventure.Monstres;

import idleadventure.Personatges.Personatge;
import idleadventure.Utils.cursorMoves;

public class Spider extends Monstre {

    
    public Spider() {
        super.imatge = "🕷️ ";

        super.nom = "Spider";
        super.vida = 5;
        super.mana = 0;
        super.stamina = 0;

        super.str = 2;
        super.agi = 0;
        super.intel = 2;
        super.dex = 0;
        super.luck = 0;
        super.expGiven = 2;
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
