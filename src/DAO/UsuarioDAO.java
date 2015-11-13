/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Welington
 */
public class UsuarioDAO {
    static final String nomeDoEsquema = "usuario";
    static final String usuarioBanco = "admin";
    static final String senhaBanco = "1234";

    Usuario usuario = new Usuario();
    Usuario usuarioNovo = new Usuario();//este usuario é apenas para para atualizar um usuario
    ConectaBanco conexao = new ConectaBanco();
    Connection c = conexao.getConnection(usuarioBanco, senhaBanco);
    
    public boolean consultaTodos() {
        try {
//            PreparedStatement p = c.prepareStatement("Select * from" + nomeDoEsquema + ".usuario;");            
                PreparedStatement p = c.prepareStatement("Select * from " + nomeDoEsquema+";" );
            ResultSet r = p.executeQuery();
            while (r.next()){
                System.out.println(" user "+r.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }    

    public Usuario consultaNome(String nome) {
        Usuario usuario = new Usuario();
        try {
//            PreparedStatement p = c.prepareStatement("Select * from" + nomeDoEsquema + ".usuario;");            
                PreparedStatement p = c.prepareStatement("Select * from " + nomeDoEsquema + " where nome = ?;");
                p.setString(1,nome);
            ResultSet r = p.executeQuery();
            while (r.next()){
                //System.out.println("ABasdfasdfasd");
                //System.out.println("User: "+r.getString("nome"));
                usuario.setNome(r.getString("nome"));
                usuario.setApelido(r.getString("apelido"));
                usuario.setSenha(r.getString("senha"));
                usuario.setDataNascimento(r.getString("datanascimento"));
                usuario.setEmail(r.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        //System.out.println("procurado por: "+nome+" nome encontrado: "+usuario.getNome());
        return usuario;
    }
    
    public boolean inserirUsuario(Entity.Usuario usuario){
        try {
            PreparedStatement p = c.prepareStatement("insert into "+nomeDoEsquema+" (nome, apelido, senha, email, dataNascimento) values (?,?,?,?,?);");   
            
            p.setString(1,usuario.getNome());        
            p.setString(2,usuario.getApelido());
            p.setString(3,usuario.getSenha());
            p.setString(4,usuario.getEmail());
            p.setDate(5,Date.valueOf(usuario.getDataNascimento()));
            //ResultSet r = p.executeQuery();
            p.executeQuery();
        }catch (SQLException ex) {
            //Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    public boolean RemoverUsuario(String nome){
        try {
            PreparedStatement p = c.prepareStatement("delete from "+nomeDoEsquema+" where nome = ?;");
            p.setString(1,nome);        
            ResultSet r = p.executeQuery();
        }catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean alterarNome(String novoNome){
        try{
            PreparedStatement p = c.prepareStatement("update "+nomeDoEsquema+" set nome= ? where nome = ?;");
            p.setString(1, novoNome);
            p.setString(2, usuario.getNome());
            p.executeQuery();
        }catch(SQLException ex){
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean alterarApelido(String novoApelido){
    try{
            PreparedStatement p = c.prepareStatement("update "+nomeDoEsquema+" set apelido= ? where nome = ?;");
            p.setString(1, novoApelido);
            p.setString(2, usuario.getNome());
            p.executeQuery();
        }catch(SQLException ex){
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean alterarSenha(String novaSenha){
    try{
            PreparedStatement p = c.prepareStatement("update "+nomeDoEsquema+" set senha= ? where nome = ?;");
            p.setString(1, novaSenha);
            p.setString(2, usuario.getNome());
            p.executeQuery();
        }catch(SQLException ex){
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
     
    public boolean alterarEmail(String email){
    try{
            PreparedStatement p = c.prepareStatement("update "+nomeDoEsquema+" set email= ? where nome = ?;");
            p.setString(1, email);
            p.setString(2, usuario.getNome());
            p.executeQuery();
            
        }catch(SQLException ex){
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean alterarDataNascimento(String novaDataNascimento){
        try{
            PreparedStatement p = c.prepareStatement("update "+nomeDoEsquema+" set dataNascimento= ? where nome = ?;");
            p.setString(1, novaDataNascimento);
            p.setString(2, usuario.getNome());
            p.executeQuery();
        }catch(SQLException ex){
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    return true;
    }
    public Usuario consultaApelido(String apelido) {
        Usuario usuario = new Usuario();
        try {
                PreparedStatement p = c.prepareStatement("Select * from " + nomeDoEsquema + " where apelido = ?;");
                p.setString(1,apelido);
            ResultSet r = p.executeQuery();
            while (r.next()){
                //System.out.println("User: "+r.getString("nome"));
                usuario.setNome(r.getString("nome"));
                usuario.setApelido(r.getString("apelido"));
                usuario.setSenha(r.getString("senha"));
                usuario.setDataNascimento(r.getString("datanascimento"));
                usuario.setEmail(r.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return usuario;
    }
    
    public Usuario consultaTelefone(String telefone) {
        Usuario usuario = new Usuario();
        try {
                PreparedStatement p = c.prepareStatement("Select * from " + nomeDoEsquema + " where telefone = ?;");
                p.setString(1,telefone);
            ResultSet r = p.executeQuery();
            while (r.next()){
                usuario.setNome(r.getString("nome"));
                usuario.setApelido(r.getString("apelido"));
                usuario.setSenha(r.getString("senha"));
                usuario.setDataNascimento(r.getString("datanascimento"));
                usuario.setEmail(r.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return usuario;
    }
    public Usuario consultaDataNasc(String dataNascimento) {
        Usuario usuario = new Usuario();
        try {
                PreparedStatement p = c.prepareStatement("Select * from " + nomeDoEsquema + " where datanascimento = ?;");
                p.setDate(1,Date.valueOf(dataNascimento));
            ResultSet r = p.executeQuery();
            while (r.next()){
                usuario.setNome(r.getString("nome"));
                usuario.setApelido(r.getString("apelido"));
                usuario.setSenha(r.getString("senha"));
                usuario.setDataNascimento(r.getString("datanascimento"));
                usuario.setEmail(r.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return usuario;
    }
    public Usuario consultaEmail(String email) {
        Usuario usuario = new Usuario();
        try {
                PreparedStatement p = c.prepareStatement("Select * from " + nomeDoEsquema + " where email = ?;");
                p.setString(1,email);
            ResultSet r = p.executeQuery();
            while (r.next()){
                usuario.setNome(r.getString("nome"));
                usuario.setApelido(r.getString("apelido"));
                usuario.setSenha(r.getString("senha"));
                usuario.setDataNascimento(r.getString("datanascimento"));
                usuario.setEmail(r.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return usuario;
    }
    
}