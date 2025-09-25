package idleadventure.Monstres;

import idleadventure.Personatges.Personatge;

public abstract class Monstre {

    String imatge;

    String nom;
    int vida;
    int mana;
    int stamina;

    int str;
    int agi;
    int intel;
    int dex;
    int luck;

    int expGiven;

    boolean interacted = false;

    public void interact(Personatge hero){
    };

    public void talk(){
    };


    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public int getStamina() {
        return stamina;
    }
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
    public int getStr() {
        return str;
    }
    public void setStr(int str) {
        this.str = str;
    }
    public int getAgi() {
        return agi;
    }
    public void setAgi(int agi) {
        this.agi = agi;
    }
    public int getIntel() {
        return intel;
    }
    public void setIntel(int intel) {
        this.intel = intel;
    }
    public int getLuck() {
        return luck;
    }
    public void setLuck(int luck) {
        this.luck = luck;
    }
    public int getDex() {
        return dex;
    }
    public void setDex(int dex) {
        this.dex = dex;
    }
    public String getImatge() {
        return imatge;
    }
    public void setImatge(String imatge) {
        this.imatge = imatge;
    }
    public boolean isInteracted() {
        return interacted;
    }
    public void setInteracted(boolean interacted) {
        this.interacted = interacted;
    }

    public int getExpGiven() {
        return expGiven;
    }

    public void setExpGiven(int expGiven) {
        this.expGiven = expGiven;
    }

    



    
}
