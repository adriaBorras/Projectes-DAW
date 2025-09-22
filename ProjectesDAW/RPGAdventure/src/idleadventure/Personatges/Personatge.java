package idleadventure.Personatges;

import idleadventure.Objectes.Objecte;
import java.util.ArrayList;

public abstract class Personatge {

    String imatge;
    ArrayList<Objecte> itemsHero = new ArrayList<>();

    String nom;
    int vida;
    int mana;
    int stamina;

    int str;
    int agi;
    int intel;
    int dex;
    int luck;

    int exp;
    boolean canFly = false;
    

    //don't do yet, use hashset
    public void addItem(Objecte objecte){
    }

    public void removeItem(Objecte objecte){
    }
    public ArrayList<Objecte> getItemsHero() {
        return itemsHero;
    }
    
    public void pickAndRemoveitem(){
        
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
    public boolean isCanFly() {
        return canFly;
    }
    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }
    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }

    





    
}
