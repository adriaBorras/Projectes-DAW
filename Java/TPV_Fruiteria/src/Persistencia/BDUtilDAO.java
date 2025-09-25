/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author david
 */
public class BDUtilDAO {

    public static void crearTaules() throws SQLException {

        ConexioDAO.connect();
        Connection conn = ConexioDAO.getConn();
        PreparedStatement stmt;

        String query = "drop table if exists productes;";
        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();

        query = "drop table if exists categories;";
        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();

        query = "CREATE TABLE if not exists categories ("
                + "codi INT AUTO_INCREMENT unique, "
                + "nom VARCHAR(50) primary key unique not null"
                + ");";
        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();

        query = "CREATE TABLE if not exists productes ("
                + "codi INT AUTO_INCREMENT primary key, "
                + "nom VARCHAR(50) unique not null, "
                + "categoria VARCHAR(50) NOT NULL, "
                + "preu double NOT NULL default 0,"
                + "tipusPreu varchar(50) NOT NULL,"
                + "stock int not null,"
                + "oferta boolean not null,"
                + "seccio int not null,"
                + "FOREIGN KEY (categoria) REFERENCES categories(nom) "
                + "ON DELETE RESTRICT ON UPDATE CASCADE"
                + ");";

        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
        
        
//        query = "drop table if exists casetes;";
//        stmt = conn.prepareStatement(query);
//        stmt.executeUpdate();

        query = "CREATE TABLE if not exists casetes ("
                + "codi INT AUTO_INCREMENT unique, "
                + "sha256Sum VARCHAR(100) primary key unique not null"
                + ");";
        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();

        stmt.close();

    }

    public static void netejaTaules() {
        ConexioDAO.connect();
        Connection conn = ConexioDAO.getConn();
        PreparedStatement stmt;
        try {
            String query = "delete from productes";
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();

            query = "delete from categories";
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
