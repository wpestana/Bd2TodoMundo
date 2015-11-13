/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Welington
 */
public class ConectaBanco {
    public Connection getConnection(String user, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/BD2APS", user, password);
        } catch (SQLException ex) {
            System.out.println("Erro sql: "+ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Exception: "+ex.getMessage());
        }
        return null;
    }   
}
