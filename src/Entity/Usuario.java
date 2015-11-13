/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author Welington
 */
public class Usuario {
    private int idUsuario;
    private String apelido;
    private String email;
    private String telefone;
    private String nome;
    private String nomeUsuario; //apelido
    private String diaNascimento;
    private String mesNascimento;
    private String anoNascimento;
    private String dataNascimento;
    private String senha;
    private ArrayList<Integer> idAmigos = new ArrayList<>();

 /*   public String getDataNascimento() {
        dataNascimento=(getAnoNascimento()+"-"+getMesNascimento()+"-"+getDiaNascimento());
        return dataNascimento;
    }
*/
    
    
    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getDiaNascimento() {
        return diaNascimento;
    }

    public void setDiaNascimento(String diaNascimento) {
        this.diaNascimento = diaNascimento;
    }

    public String getMesNascimento() {
        return mesNascimento;
    }

    public void setMesNascimento(String mesNascimento) {
        this.mesNascimento = mesNascimento;
    }

    public String getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(String anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public ArrayList<Integer> getIdAmigos() {
        return idAmigos;
    }

    public void setIdAmigos(ArrayList<Integer> idAmigos) {
        this.idAmigos = idAmigos;
    }
    
    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
}