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
public class Dicionario {
    private Set<Palavra> ListaPalavras = new HashSet<>();
    

    public void adiciona(String fonetica, String grafia, Set<String> significados){
        Palavra p = new Palavra(fonetica, grafia);
        
        // Busca sinonimo de cada significado e caso não exista cria um. Depois relaciona palavra com sinonimo.
        for (String sig : significados){
            
            Sinonimo SinonimoResp = null;
            SinonimoResp = buscaSinonimo(sig);
           
            if (SinonimoResp != null){
                p.adicionaSinonimo(SinonimoResp);
                SinonimoResp.adicionaPalavra(p);
            }
            else{
                Sinonimo SinonimoNovo = new Sinonimo();
                SinonimoNovo.atribuirSignificado(sig);
                p.adicionaSinonimo(SinonimoNovo);
                SinonimoNovo.adicionaPalavra(p);
            }
        }
        this.ListaPalavras.add(p);
    }
    
    // Auxiliar de "adiciona"
    public Sinonimo buscaSinonimo(String significado){
        for (Palavra p:this.ListaPalavras){
            for (Sinonimo s: p.getSinonimos()){
                if (significado.equals(s.getSignificado())){
                    return s;
                }
            }
        }
        
        return null;
    }
    
    // Lista todas as palavras do dicionario com fonética, grafia e sinônimos.
    public void ListaItens(){
        for (Palavra p: this.ListaPalavras){
            System.out.println("---------------------------------");
            p.getPalavra();
        }
    }
    
    //Apenas para testar funcionamento.(ignorar)
    public void ListaPorSignificado(){
        Set<Sinonimo> ItensImpressos = new HashSet<>();
        for (Palavra p:this.ListaPalavras){
            Set<Sinonimo> auxS = p.getSinonimos();
            for (Sinonimo s: auxS){
                if (!ItensImpressos.contains(s)){
                    ItensImpressos.add(s);
                    System.out.println("===================");
                    System.out.print("Palavras: ");
                    Set<Palavra> auxP = s.getPalavras();
                    for (Palavra word: auxP){
                        System.out.print(word.getGrafia() + " ");
                    }
                    System.out.println("\n"+s.getSignificado());
                }
            }
        }
    }
}
