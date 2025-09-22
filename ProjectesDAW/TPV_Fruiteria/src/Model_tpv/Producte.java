/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model_tpv;

/**
 *
 * @author borras
 */
public class Producte {
    
    int codi;
    String nom;
    Categoria categoria;
    double preu;
    String tipusPreu; //unitari,pes,paquet.
    int stock;
    boolean oferta;
    int seccio;

   
    public Producte(String nom, Categoria categoria, double preu, String tipusPreu, int stock, boolean oferta, int seccio) {
        //this.codi = codi;
        this.nom = nom;
        this.categoria = categoria;
        this.preu = preu;
        this.tipusPreu = tipusPreu;
        this.stock = stock;
        this.oferta = oferta;
        this.seccio = seccio;
    }

    public Producte() {
    }
    
    

    public int getCodi() {
        return codi;
    }

    public int getSeccio() {
        return seccio;
    }

    public void setSeccio(int seccio) {
        this.seccio = seccio;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public String getTipusPreu() {
        return tipusPreu;
    }

    public void setTipusPreu(String tipusPreu) {
        this.tipusPreu = tipusPreu;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isOferta() {
        return oferta;
    }

    public void setOferta(boolean oferta) {
        this.oferta = oferta;
    }
    
    
    
    
}
