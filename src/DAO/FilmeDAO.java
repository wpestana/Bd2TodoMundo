/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Filme;
import Entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Welington
 */
public class FilmeDAO {
    static final String nomeDoEsquema = "filme";
    static final String usuarioBanco = "admin";
    static final String senhaBanco = "1234";

    Usuario usuario = new Usuario();
    Usuario usuarioNovo = new Usuario();//este usuario é apenas para para atualizar um usuario
    Filme filme = new Filme();
    ConectaBanco conexao = new ConectaBanco();
    Connection c = conexao.getConnection(usuarioBanco, senhaBanco);
    
    /* Este método mostra todos os dados da tabela*/
    public boolean consultaTodos() {
        try {
//            PreparedStatement p = c.prepareStatement("Select * from" + nomeDoEsquema + ".usuario;");            
                PreparedStatement p = c.prepareStatement("Select * from " + nomeDoEsquema+";" );
            ResultSet r = p.executeQuery();
            while (r.next()){
                System.out.print(" ator principal "+r.getString("atorprincipal"));
                System.out.print("filme "+r.getString("nomeFilme"));
                
                System.out.print(" genero "+r.getString("genero"));
                System.out.print(" duração "+r.getString("duracao"));
                System.out.println(" descricao "+r.getString("descricao"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    /* Este método é para consulta de strings na tabela
    note que usei o operador like, portanto pode ser usado para encontrar 
    nomes que se iniciam com o termo da procura*/
    public ResultSet consultaNome(String nome) {
        if(nome.isEmpty())//Este if retorna null se não há nada digitado, sem nem mesmo fazer a procura
            return null;
        System.out.println("Classe filmeDao");
        System.out.println("Select * from "+nomeDoEsquema+" where nomefilme = "+nome+";");
        try {         
                PreparedStatement p = c.prepareStatement("Select * from " + nomeDoEsquema +" where nomeFilme like ?" );                
                p.setString(1, nome+"%");
            ResultSet  r = p.executeQuery();
            if(!r.isBeforeFirst()){return null;} //Esta linha retorna null caso não haja resultados após a pesquisa
            /*
                Estes códigos são necessários apenas para exibir dados no console
                Entretanto note que podem ser úteis para desenvolver as janelas
                por isso deixei
            */    
                while (r.next()){                            
                    System.out.print("filme "+r.getString("nomefilme"));
                    System.out.print(" ator principal "+r.getString("atorprincipal"));
                    System.out.print(" genero "+r.getString("genero"));
                    System.out.print(" duração "+r.getString("duracao"));
                    System.out.println(" descricao "+r.getString("descricao"));
                }
            
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
    
        public Filme retornaNome(String nome) {
        if(nome.isEmpty()){//Este if retorna null se não há nada digitado, sem nem mesmo fazer a procura
            return null;}
            System.out.println("Pesquisando por: "+nome);
        Filme filme = new Filme();
        //System.out.println("Classe filmeDao");
        //System.out.println("Select * from "+nomeDoEsquema+" where nomefilme = "+nome+";");
        try {         
                //PreparedStatement p = c.prepareStatement("Select * from " + nomeDoEsquema +" where nomeFilme like ?" );                
            PreparedStatement p = c.prepareStatement("Select * from " + nomeDoEsquema +" where nomeFilme = ?;" );                
                p.setString(1, nome);
                ResultSet  r = p.executeQuery();
                
            if(!r.isBeforeFirst()){return null;} //Esta linha retorna null caso não haja resultados após a pesquisa
            while(r.next()){
                    filme.setNomeFilme(r.getString("nomefilme"));
                    filme.setAtorPrincipal(r.getString("atorprincipal"));
                    filme.setGenero(r.getString("genero"));
                    filme.setDescricao(r.getString("descricao"));
                    filme.setDuracao(r.getInt("duracao"));
                }
            
            /*
                Estes códigos são necessários apenas para exibir dados no console
                Entretanto note que podem ser úteis para desenvolver as janelas
                por isso deixei
            //    
                while (r.next()){                            
                    System.out.print("filme "+r.getString("nomefilme"));
                    System.out.print(" ator principal "+r.getString("atorprincipal"));
                    System.out.print(" genero "+r.getString("genero"));
                    System.out.print(" duração "+r.getString("duracao"));
                    System.out.println(" descricao "+r.getString("descricao"));
                }*/
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        System.out.println("Entrei no laço , nome filme é: "+filme.getNomeFilme());
        return filme;
    }
   
    public void remover(String nome){
        
        try {
            PreparedStatement p = c.prepareStatement("remove from "+nomeDoEsquema+" where nome = ?;");
            p.setString(1, nome);
            p.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void iserir(Filme filme){
        try {
            PreparedStatement p = c.prepareStatement("insert into "+nomeDoEsquema+" (nomeFilme, atorprincipal,genero,duracao,descricao) values ?,?,?,?,?;");
            p.setString(1, filme.getNomeFilme());
            p.setString(2, filme.getAtorPrincipal());
            p.setString(3, filme.getGenero());
            p.setInt(4, filme.getDuracao());
            p.setString(5, filme.getDescricao());
            p.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void alteraNome (String novoNome){
        try {
            PreparedStatement p = c.prepareStatement("update "+nomeDoEsquema+" set ? where nomeFilme = ?;");
            p.setString(1, novoNome);
            p.setString(2, filme.getNomeFilme());
            p.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void alteraAtor(String novoFilme){
        PreparedStatement p;
        try {
            p = c.prepareStatement("update "+nomeDoEsquema+" set atorPrincipal = ? where nomeFilme=?;");
            p.setString(1, novoFilme);
            p.setString(2, novoFilme);
            p.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void alteraGenero(String novoGenero){
        try {
            PreparedStatement p = c.prepareStatement("update "+nomeDoEsquema+" set genero = ? where nomeFilme=?;");
            p.setString(1,novoGenero);
            p.setString(2,filme.getNomeFilme());
            p.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void alteraDuracao(int novaDuracao){
        try {
            PreparedStatement p = c.prepareStatement("update "+nomeDoEsquema+" set duracao = ? where nomeFilme = ?;");
            p.setInt(1, novaDuracao);
            p.setString(2, filme.getNomeFilme());
            p.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void alteraDescricao(String novaDescricao){
        try {
            PreparedStatement p = c.prepareStatement("update "+nomeDoEsquema+" set descricao = ? where nomeFilme = ?;");
            p.setString(1,novaDescricao);
            p.setString(2, filme.getNomeFilme());            
            p.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }

}
