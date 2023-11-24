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
    // aqui acho que tem que ser usada algum tipo de lista ordenada, porque ele deve querer que as palavras estejam 
    // organizadas e sejam inseridas em ordem alfabética, como em um dicionário real
    private Set<Palavra> ListaPalavras = new HashSet<>();
    
    // na hora de adicionar, as palavras tem que ser inseridas em ordem alfabética
    public void adiciona(String fonetica, String grafia, Set<String> significados){
        Palavra p = new Palavra(fonetica, grafia);
        // e se a palavra já estiver no dicionário? Ele vai reclamar que foi criado um novo objeto desnecessário. Eu pensei em 
        // 4 casos:
        //          1 - palavra já existe no dicionário e já existe uma palavra no dicionário com o mesmo significado passado
        //          2 - palavra já existe no dicionário, mas não existe uma palavra no dicionário com o mesmo significado
        //          3 - palavra não existe no dicionário, mas existe uma palavra no dicionário com o mesmo significado passado
        //          4 - nem palavra nem significado existem no dicionário
        // cada um desses casos vai precisar de uma lógica diferente, e uma nova palavra deveria ser criada apenas quando ela não
        // estiver presente no dicionário.
        
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
    // Em vez de ter que mudar de Set para Array, pode ser que baste as palavras serem listadas em ordem alfabética, mas guardadas
    // em qualquer ordem no Set
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
