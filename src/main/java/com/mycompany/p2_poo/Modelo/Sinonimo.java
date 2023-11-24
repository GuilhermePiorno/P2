/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p2_poo.Modelo;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Home
 */
public class Sinonimo {
    private Set<Palavra> palavrasSinonimas = new HashSet<>();
    private String significado;
    
    Sinonimo(){
    }
    
    Sinonimo(String sig){
        this.significado = sig;
    }
    
    public void atribuirSignificado(String s){
        this.significado = s;
    }
        
    public void adicionaPalavra(Palavra p){
        palavrasSinonimas.add(p);
    }
    
    public String getSignificado(){
        return significado;
    }
    
    //Apenas para testar funcionamento.(ignorar)
    public Set<Palavra> getPalavras(){
        return palavrasSinonimas;
    }
}
