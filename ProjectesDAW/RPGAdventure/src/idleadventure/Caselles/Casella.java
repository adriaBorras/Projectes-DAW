/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package idleadventure.Caselles;

import idleadventure.Monstres.Monstre;
import idleadventure.NPC.NPC;

/**
 *
 * @author borras
 */
public abstract class Casella {

    String nom;
    String imatge;
    boolean walkable;
    int id = 0;
    int position[] = {-1,-1};
    boolean isPlayerOn = false;
    Monstre monstre;
    NPC npc;
    
    public void mostraPaisatge(int distancia,int groundPosition){
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public boolean isWalkable() {
        return walkable;
    }

    public void setWalkable(boolean walkable) {
        this.walkable = walkable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public boolean isPlayerOn() {
        return isPlayerOn;
    }

    public void setPlayerOn(boolean isPlayerOn) {
        this.isPlayerOn = isPlayerOn;
    }
    
    public void mostraInfo() {
    }

    public Monstre getMonstre() {
        return monstre;
    }

    public void setMonstre(Monstre monstre) {
        this.monstre = monstre;
    }

    public NPC getNpc() {
        return npc;
    }

    public void setNpc(NPC npc) {
        this.npc = npc;
    }
    
    
}
