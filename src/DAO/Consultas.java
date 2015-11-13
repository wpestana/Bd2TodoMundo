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
    
}
