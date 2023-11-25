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
public class Palavra {
    private List<Sinonimo> listaSinonimos = new ArrayList<>(); //Relação muitos p/ muitos do diagrama.
    private String fonetica;    //exigencia do diagrama.
    private String grafia;      //exigencia do diagrama.
    
    // Diagrama exige construtor vazio
    public Palavra(){
    }
    
    // Diagram exige construtor com fonetica/grafia.
    public Palavra(String grafia, String fonetica){
        this.fonetica = fonetica;
        this.grafia = grafia;
    }
    
    
    // Auxiliar
    public void adicionaSinonimo(Sinonimo s){
        this.listaSinonimos.add(s);
    }
    
    // Auxiliar
    public List<Sinonimo> getSinonimos(){
        return listaSinonimos;
    }
    
    // Auxiliar
    public void consultaPalavra(){
        System.out.println("---------------------------------");
        System.out.println("Fonética: "+this.fonetica);
        System.out.println("Grafia: "+this.grafia);
        System.out.println("Significados: ");
        for (Sinonimo s: listaSinonimos){
            System.out.println("-"+s.getSignificado()+"\n");
        }
    }
    
    //Apenas para testar funcionamento.(ignorar)
    public String getGrafia(){
        return grafia;
    }
}
