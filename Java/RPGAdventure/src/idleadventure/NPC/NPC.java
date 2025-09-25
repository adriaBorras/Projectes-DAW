package idleadventure.NPC;

import idleadventure.Caselles.Casella;
import idleadventure.Objectes.Objecte;
import idleadventure.Personatges.Personatge;

public abstract class NPC {

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
    int questStage = 0;
    
    boolean interacted = false;
    boolean walkable;

    
    
    public void interact(Personatge hero){
    };

    public void talk(){
    };

    public void give(Objecte item, Casella[][] caselles){
    }
    
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

    public boolean isWalkable() {
        return walkable;
    }

    public void setWalkable(boolean walkable) {
        this.walkable = walkable;
    }

    public int getExpGiven() {
        return expGiven;
    }

    public void setExpGiven(int expGiven) {
        this.expGiven = expGiven;
    }

    public int getQuestStage() {
        return questStage;
    }

    public void setQuestStage(int questStage) {
        this.questStage = questStage;
    }





    
}
