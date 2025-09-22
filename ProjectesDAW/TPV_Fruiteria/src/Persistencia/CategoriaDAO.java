/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model_tpv.Categoria;
import static Persistencia.ConexioDAO.conn;
import static Persistencia.ConexioDAO.connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author borras
 */
public class CategoriaDAO {
     private static CategoriaDAO instancia = null;

    private CategoriaDAO() {
        connect();
    }

    public static CategoriaDAO getInstance() {
        if (instancia == null) {
            instancia = new CategoriaDAO();
        }
        return instancia;
    }

    public boolean afegirCategoria(Categoria categoria) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO categories (nom) VALUES (?)");
        stmt.setString(1, categoria.getNom());     

        int count = stmt.executeUpdate();

        System.out.println("Categories afegides: " + count);
        stmt.close();
        return count == 1;
    }

    public ArrayList<Categoria> getCategories() throws SQLException {
        
        ArrayList<Categoria> llistaCategories = new ArrayList<>();
        
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM categories");        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Categoria c = new Categoria();
            c.setCodi(rs.getInt("codi"));
            c.setNom(rs.getString("nom"));
            
            llistaCategories.add(c);
        }

        rs.close();
        stmt.close();

        return llistaCategories;
    }
    
    public boolean eliminarCategoria(Categoria categoria) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("delete from categories where nom = ?");
        stmt.setString(1, categoria.getNom());     

        int count = stmt.executeUpdate();

        System.out.println("Categories eliminades: " + count);
        
        stmt.close();
        return count == 1;
    }
    
    
}
