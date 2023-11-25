/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p2_poo.questao1.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Home
 */
public class Sinonimo {
    private List<Palavra> palavras = new ArrayList<>();
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
        palavras.add(p);
    }
    
    public String getSignificado(){
        return significado;
    }
    
    //Apenas para testar funcionamento.(ignorar)
    public List<Palavra> getPalavras(){
        return palavras;
    }
}
