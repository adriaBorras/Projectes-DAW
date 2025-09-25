package idleadventure.NPC;

import idleadventure.Caselles.Casella;
import idleadventure.Objectes.Objecte;
import idleadventure.Personatges.Personatge;
import idleadventure.Utils.cursorMoves;

public class Worker extends NPC {

    public Worker() {
        super.imatge = "👷";

        super.nom = "Worker";
        super.vida = 100;
        super.mana = 0;
        super.stamina = 50;

        super.str = 9;
        super.agi = 2;
        super.intel = 4;
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
                System.out.println("It's just a worker!");
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
                        Yo!! I'm building the bridge!
                        \033[3CBut i need a Stick!
                        """);
                break;
            case 1:
                cursorMoves.moveXY(7, 3);//space ||
                System.out.println("""
                        Yooooo!! bro! that's what I
                        \033[3Cneed! You can cross now!
                        """);
                break;
            default:
                throw new AssertionError();
        }

    };

    public void give(Objecte item, Casella[][] caselles) {
        if (item.getNom() == "Stick") {
            this.questStage++;
            this.talk();
        }
    }

}
