/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetox;

import DAO.FilmeDAO;

/**
 *
 * @author Welington
 */
public class ProjetoX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FilmeDAO filme = new FilmeDAO();
        
        filme.consultaTodos();
    }
    
}
