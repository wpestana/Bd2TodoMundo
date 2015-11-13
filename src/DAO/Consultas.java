/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * Classe criada com o propósito de armazenar as consultas extras no banco
 */
package DAO;

import Entity.Filme;
import Entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Welington
 */
public class Consultas {
    
    static final String usuarioBanco = "admin";
    static final String senhaBanco = "1234";
    /* Essas variáveis são importantes para caso seja alterado no banco, o nome das colunas */
    //Para conectar ao esquema usuario:
    static final String esquemaUsuario = "usuario";
    //Para conectar ao esquema filme:
    static final String esquemaFilme = "filme";

    Usuario usuario = new Usuario();
    Filme filme = new Filme();
    ConectaBanco conexao = new ConectaBanco();
    Connection c = conexao.getConnection(usuarioBanco, senhaBanco);
    
    ///*
    // Este método mostra todos os dados da tabela
    public ArrayList<Filme> consultaTodos (){
        ArrayList<Filme>listadeFilme= new ArrayList<Filme>();
        try{
            PreparedStatement p= c.prepareStatement("select * from filme");
            ResultSet r = p.executeQuery();
            while(r.next()){
                Filme filme=new Filme();
                filme.setGenero(r.getString("genero"));
                filme.setDescricao(r.getString("descricao"));
                filme.setDuracao(r.getInt("duracao"));
                filme.setAtorPrincipal(r.getString("atorPrincipal"));
                filme.setIdFilme(r.getInt("idUsuario"));
                listadeFilme.add(filme);
            }
            
        }catch (SQLException ex){
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE,null,ex);
            return null;
            
        }
        return listadeFilme;
    }
        
    public Filme consultarNome(String nomeFilme) {
        ArrayList<Filme> listadefilme=new ArrayList<Filme>();
        Filme filmes=null;
        try {
//            PreparedStatement p = c.prepareStatement("Select * from" + nomeDoEsquema + ".usuario;");            
            PreparedStatement p = c.prepareStatement("Select * from filme  where nomeFilme like ?;");
            p.setString(1, nomeFilme);
            ResultSet r = p.executeQuery();
            
            while(r.next()){
                filmes=new Filme();
                filmes.setGenero(r.getString("genero"));
                filmes.setDescricao(r.getString("descricao"));
                filmes.setDuracao(r.getInt("duracao"));
                filmes.setAtorPrincipal(r.getString("atorPrincipal"));
                filmes.setIdFilme(r.getInt("idUsuario"));
                filmes.setNomeFilme(r.getString("nomeFilme"));
                listadefilme.add(filmes);
                System.out.println(filmes.getNomeFilme());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return filmes;
    }
    public Filme consultarGenero(String genero) {
        ArrayList<Filme> listadefilme=new ArrayList<Filme>();
        Filme filmes=null;
        try {
//            PreparedStatement p = c.prepareStatement("Select * from" + nomeDoEsquema + ".usuario;");            
            PreparedStatement p = c.prepareStatement("Select * from filme  where genero like ?;");
            p.setString(1, genero);
            ResultSet r = p.executeQuery();
            
            while(r.next()){
                filmes=new Filme();
                filmes.setGenero(r.getString("genero"));
                filmes.setDescricao(r.getString("descricao"));
                filmes.setDuracao(r.getInt("duracao"));
                filmes.setAtorPrincipal(r.getString("atorPrincipal"));
                filmes.setIdFilme(r.getInt("idUsuario"));
                filmes.setNomeFilme(r.getString("nomeFilme"));
                listadefilme.add(filmes);
                System.out.println(filmes.getNomeFilme());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return filmes;
    }
    
    public Filme consultarDuracao(int duracao) {
        ArrayList<Filme> listadefilme=new ArrayList<Filme>();
        Filme filmes=null;
        try {
//            PreparedStatement p = c.prepareStatement("Select * from" + nomeDoEsquema + ".usuario;");            
            PreparedStatement p = c.prepareStatement("Select * from filme  where duracao like ?;");
            p.setInt(1, duracao);
            ResultSet r = p.executeQuery();
            
            while(r.next()){
                filmes=new Filme();
                filmes.setGenero(r.getString("genero"));
                filmes.setDescricao(r.getString("descricao"));
                filmes.setDuracao(r.getInt("duracao"));
                filmes.setAtorPrincipal(r.getString("atorPrincipal"));
                filmes.setIdFilme(r.getInt("idUsuario"));
                filmes.setNomeFilme(r.getString("nomeFilme"));
                listadefilme.add(filmes);
                System.out.println(filmes.getNomeFilme());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return filmes;
    }
   
     public Filme consultarAtorPrincipal(String atorPrincipal) {
        ArrayList<Filme> listadefilme=new ArrayList<Filme>();
        Filme filmes = null;
        try {
//            PreparedStatement p = c.prepareStatement("Select * from" + nomeDoEsquema + ".usuario;");            
            PreparedStatement p = c.prepareStatement("Select * from filme  where atorPrincipal like ?;");
            p.setString(1, atorPrincipal);
            ResultSet r = p.executeQuery();
            
            while(r.next()){
                filmes=new Filme();
                filmes.setGenero(r.getString("genero"));
                filmes.setDescricao(r.getString("descricao"));
                filmes.setDuracao(r.getInt("duracao"));
                filmes.setAtorPrincipal(r.getString("atorPrincipal"));
                filmes.setIdFilme(r.getInt("idUsuario"));
                filmes.setNomeFilme(r.getString("nomeFilme"));
                listadefilme.add(filmes);
                System.out.println(filmes.getNomeFilme());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return filmes;
    }
   
     
     public Filme consultarDescricao(String descricao) {
        ArrayList<Filme> listadefilme=new ArrayList<Filme>();
        Filme filmes = null;
        try {
            PreparedStatement p = c.prepareStatement("Select * from filme  where descricao like ?;");
            p.setString(1, descricao);
            ResultSet r = p.executeQuery();

            while(r.next()){
                filmes=new Filme();
                filmes.setGenero(r.getString("genero"));
                filmes.setDescricao(r.getString("descricao"));
                filmes.setDuracao(r.getInt("duracao"));
                filmes.setAtorPrincipal(r.getString("atorPrincipal"));
                filmes.setIdFilme(r.getInt("idUsuario"));
                filmes.setNomeFilme(r.getString("nomeFilme"));
                listadefilme.add(filmes);
                System.out.println(filmes.getNomeFilme());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return filmes;
    }
     
     public Filme consultaAvancada(String nomeFilme, String atorPrincipal, String genero, int duracao, String descricao) {
        ArrayList<Filme> listadefilme=new ArrayList<Filme>();
        Filme filmes = null;
        try {
            PreparedStatement p = c.prepareStatement("Select * from filme  where descricao like ?;");
            p.setString(1, descricao);
            ResultSet r = p.executeQuery();

            while(r.next()){
                filmes=new Filme();
                filmes.setGenero(r.getString("genero"));
                filmes.setDescricao(r.getString("descricao"));
                filmes.setDuracao(r.getInt("duracao"));
                filmes.setAtorPrincipal(r.getString("atorPrincipal"));
                filmes.setIdFilme(r.getInt("idUsuario"));
                filmes.setNomeFilme(r.getString("nomeFilme"));
                listadefilme.add(filmes);
                System.out.println(filmes.getNomeFilme());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return filmes;
    }

    public void consultaTodos(Filme filme) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void consultarNome(Filme filme) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //*/
}
