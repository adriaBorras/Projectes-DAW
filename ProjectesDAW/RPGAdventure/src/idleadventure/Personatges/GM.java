package idleadventure.Personatges;

import idleadventure.Objectes.Objecte;

public class GM extends Personatge {

    
    public GM() {
        super.imatge = "😈";

        super.nom = "GM";
        super.vida = 100;
        super.mana = 100;
        super.stamina = 5000;

        super.str = 100;
        super.agi = 100;
        super.intel = 100;
        super.dex = 100;
        super.luck = 100;
        super.canFly = true;

    }
    @Override
    public void addItem(Objecte objecte){
        super.itemsHero.add(objecte);
    }

    @Override
    public void removeItem(Objecte objecte){

    }
}
