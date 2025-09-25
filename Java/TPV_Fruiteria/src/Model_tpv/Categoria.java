/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model_tpv;

/**
 *
 * @author borras
 */
public class Categoria {
    
    int codi;
    String nom;

    public Categoria(String nom) {
        //this.codi = codi;
        this.nom = nom;
    }

    public Categoria() {
    }
    

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    
}
