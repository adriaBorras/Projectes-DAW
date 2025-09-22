package idleadventure.NPC;

import idleadventure.Caselles.Casella;
import idleadventure.Objectes.Objecte;
import idleadventure.Personatges.Personatge;
import idleadventure.Utils.cursorMoves;

public class PoliceMan extends NPC {

    
    public PoliceMan() {
        super.imatge = "👮";

        super.nom = "Police";
        super.vida = 100;
        super.mana = 0;
        super.stamina = 50;

        super.str = 20;
        super.agi = 2;
        super.intel = 3;
        super.dex = 2;
        super.luck = 1;
        super.walkable = true;
    }

    @Override
    public void interact(Personatge hero) {
        if (!super.interacted) {
            if (hero.getIntel() >= this.intel) {
                cursorMoves.moveXY(7, 3);
                System.out.println("You know a bit more about it");
                super.interacted = true;
            } else {
                cursorMoves.moveXY(7, 3);
                System.out.println("It's just a \033[9m Dog \033[29m Policeman!");
            }
        } else {
            cursorMoves.moveXY(7, 3);
            System.out.println("All already known about him");
        }
    };

    @Override
    public void talk() {
        switch (super.questStage) {
            case 0:
                cursorMoves.moveXY(7, 3);//space ||
                System.out.println("""
                        Be careful...
                        \033[3CI have power!
                        """);
                break;
            case 1:
                cursorMoves.moveXY(7, 3);//space ||
                System.out.println("""
                        I told you...
                        \033[3CYou will regret that!
                        """);
                break;
            default:
                throw new AssertionError();
        }

    };

    public void give(Objecte item, Casella[][] caselles) {
        // if (item.getNom() == "Stick") {
        //     this.questStage++;
        //     this.talk();
        // }
    }

}

