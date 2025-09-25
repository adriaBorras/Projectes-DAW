/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model_tpv.Categoria;
import Model_tpv.Producte;
import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author david
 */
public class ProducteDAO extends ConexioDAO {

    private static ProducteDAO instancia = null;

    private ProducteDAO() {
        connect();
    }

    public static ProducteDAO getInstance() {
        if (instancia == null) {
            instancia = new ProducteDAO();
        }
        return instancia;
    }

    public boolean afegirProducte(Producte producte) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO productes (nom,categoria,preu,tipusPreu,stock,oferta,seccio) VALUES (?,?,?,?,?,?,?)");
        stmt.setString(1, producte.getNom());
        stmt.setString(2, producte.getCategoria().getNom());
        stmt.setDouble(3, producte.getPreu());
        stmt.setString(4, producte.getTipusPreu());
        stmt.setInt(5, producte.getStock());
        stmt.setBoolean(6, producte.isOferta());
        stmt.setInt(7, producte.getSeccio());

        int count = stmt.executeUpdate();

        System.out.println("Productes afegits: " + count);
        stmt.close();
        return count == 1;
    }
    
    public boolean modificarProducte(Producte producte) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("UPDATE productes SET nom = ?, categoria = ?, preu = ?, tipusPreu = ?, stock = ?, oferta = ?, seccio = ? WHERE nom = ?;");
        stmt.setString(1, producte.getNom());
        stmt.setString(2, producte.getCategoria().getNom());
        stmt.setDouble(3, producte.getPreu());
        stmt.setString(4, producte.getTipusPreu());
        stmt.setInt(5, producte.getStock());
        stmt.setBoolean(6, producte.isOferta());
        stmt.setInt(7, producte.getSeccio());
        stmt.setString(8, producte.getNom());

        int count = stmt.executeUpdate();

        System.out.println("Productes modificats: " + count);
        stmt.close();
        return count == 1;
    }

    public ArrayList<Producte> getProductes(String ordre, String direccio) throws SQLException {

        ArrayList<Producte> llistaProductes = new ArrayList<>();
        ResultSet rs = getProductesOrdenats(ordre, direccio);

        while (rs.next()) {
            //creem un producte i una categoria provisionals per guardar els valors dels objectes de la BBDD.
            Producte p = new Producte();
            Categoria c = new Categoria();
            c.setNom(rs.getString("categoria"));

            //asignem els valors del objecte extrets de la BBDD.
            p.setCodi(rs.getInt("codi"));
            p.setNom(rs.getString("nom"));
            p.setCategoria(c);
            p.setPreu(rs.getDouble("preu"));
            p.setTipusPreu(rs.getString("tipusPreu"));
            p.setStock(rs.getInt("stock"));
            p.setOferta(rs.getBoolean("oferta"));
            p.setSeccio(rs.getInt("seccio"));

            llistaProductes.add(p);
        }

        rs.close();
        //stmt.close();
        return llistaProductes;
    }

    public ArrayList<Producte> getProductesPerStock(int stockNumber) throws SQLException {

        ArrayList<Producte> llistaProductes = new ArrayList<>();
        ResultSet rs = getProductesStock(stockNumber);

        while (rs.next()) {
            //creem un producte i una categoria provisionals per guardar els valors dels objectes de la BBDD.
            Producte p = new Producte();
            Categoria c = new Categoria();
            c.setNom(rs.getString("categoria"));

            //asignem els valors del objecte extrets de la BBDD.
            p.setCodi(rs.getInt("codi"));
            p.setNom(rs.getString("nom"));
            p.setCategoria(c);
            p.setPreu(rs.getDouble("preu"));
            p.setTipusPreu(rs.getString("tipusPreu"));
            p.setStock(rs.getInt("stock"));
            p.setOferta(rs.getBoolean("oferta"));
            p.setSeccio(rs.getInt("seccio"));

            llistaProductes.add(p);
        }

        //rs.close();
        //stmt.close();
        return llistaProductes;

    }

    public ResultSet getProductesStock(int stockNumber) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM productes where stock <= ? order by codi desc");
        ResultSet rs;
        stmt.setInt(1, stockNumber);

        rs = stmt.executeQuery();

        //stmt.close();
        //rs.close();
        return rs;
    }

    public ArrayList<Producte> getProductes(String dadaBuscada, String buscarPer, String ordenarPer) throws SQLException {

        ArrayList<Producte> llistaProductes = new ArrayList<>();
        ResultSet rs = getProductesBuscats(dadaBuscada, buscarPer, ordenarPer);

        while (rs.next()) {
            //creem un producte i una categoria provisionals per guardar els valors dels objectes de la BBDD.
            Producte p = new Producte();
            Categoria c = new Categoria();
            c.setNom(rs.getString("categoria"));

            //asignem els valors del objecte extrets de la BBDD.
            p.setCodi(rs.getInt("codi"));
            p.setNom(rs.getString("nom"));
            p.setCategoria(c);
            p.setPreu(rs.getDouble("preu"));
            p.setTipusPreu(rs.getString("tipusPreu"));
            p.setStock(rs.getInt("stock"));
            p.setOferta(rs.getBoolean("oferta"));
            p.setSeccio(rs.getInt("seccio"));

            llistaProductes.add(p);
        }

        rs.close();
        //stmt.close();
        return llistaProductes;
    }

    //llista de tots els productes al iniciar el programa
    public ResultSet getProductesOrdenats(String ordre, String direccio) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM productes order by " + ordre + " " + direccio);
        ResultSet rs;

        rs = stmt.executeQuery();

        //stmt.close();
        //rs.close();
        return rs;
    }

    // buscats pels camps de l'interficie
    public ResultSet getProductesBuscats(String dadaBuscada, String buscarPer, String ordenarPer) throws SQLException {

        //validar el nom de les columnes 
        ArrayList<String> columnesValides = new ArrayList<>(Arrays.asList("codi", "nom", "categoria", "preu", "tipusPreu", "stock", "oferta", "seccio"));
        if (!columnesValides.contains(buscarPer) || !columnesValides.contains(ordenarPer)) {
            //System.out.println("Les columnes i els camps buscarPer i ordenarPer no coincideixen");
            throw new SQLException("Les columnes i els camps buscarPer i ordenarPer no coincideixen");
        }

        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM productes where " + buscarPer + " like " + " ? " + " order by " + ordenarPer + ";");
        ResultSet rs;
        stmt.setString(1, dadaBuscada);

        rs = stmt.executeQuery();

        //stmt.close();
        //rs.close();
        return rs;
    }

    public boolean eliminarProducte(int codi) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("delete from productes where codi = ?");
        stmt.setInt(1, codi);

        int count = stmt.executeUpdate();

        System.out.println("Productes eliminats: " + count);
        stmt.close();
        return count == 1;
    }

    public int getMaxStock() throws SQLException {
        int maxStock = 0;
        PreparedStatement stmt = conn.prepareStatement("select max(stock) stock from productes;");
        //stmt.setInt(1, codi);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            maxStock = rs.getInt("stock");
        }

        stmt.close();
        rs.close();
        return maxStock;
    }

}
