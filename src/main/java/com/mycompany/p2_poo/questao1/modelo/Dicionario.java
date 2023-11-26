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
public class Dicionario {
    // aqui acho que tem que ser usada algum tipo de lista ordenada, porque ele deve querer que as palavras estejam 
    // organizadas e sejam inseridas em ordem alfabética, como em um dicionário real
    private List<Palavra> palavras = new ArrayList<>();
    
    // na hora de adicionar, as palavras tem que ser inseridas em ordem alfabética
    public void adiciona(String fonetica, String grafia, List<String> significados){
        Palavra p = new Palavra(grafia, fonetica);
        
        // Busca sinonimo de cada significado e caso não exista cria um. Depois relaciona palavra com sinonimo.
        for (String sig : significados){
            
            Sinonimo sinonimoResp = null;
            sinonimoResp = buscaSinonimo(sig);
           
            if (sinonimoResp != null){
                p.adicionaSinonimo(sinonimoResp);
                sinonimoResp.adicionaPalavra(p);
            }
            else{
                Sinonimo sinonimoNovo = new Sinonimo();
                sinonimoNovo.atribuirSignificado(sig);
                p.adicionaSinonimo(sinonimoNovo);
                sinonimoNovo.adicionaPalavra(p);
            }
        }
        this.palavras.add(p);
    }
    
    // Auxiliar p/ condição de adicionar
    public Palavra buscaPalavra(String grafia){
        for(Palavra p: palavras){
            if (grafia.equals(p.getGrafia())){
                return p;
            }
        }
        return null;
    }
    
    // Auxiliar de "adiciona"
    public Sinonimo buscaSinonimo(String significado){
        for (Palavra p:this.palavras){
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
//    public void listaTodasPalavras(){
//        for (Palavra p: this.palavras){
//            p.consultaPalavra();
//        }
//    }
    
   
//    // Lista grafia, fonetica e significado de uma palavra específica.
//    public void consultaPalavra(String consulta){
//        Palavra aux = buscaPalavra(consulta);
//        if (aux != null){
//            aux.consultaPalavra();
//            return;
//        }
//        System.out.println("\""+consulta+"\" não se encontra do dicionário.");
//    }
    
    //Apenas para testar funcionamento.(ignorar)
    public void listaPorSignificado(){
        List<Sinonimo> itensImpressos = new ArrayList<>();
        for (Palavra p:this.palavras){
            List<Sinonimo> auxS = p.getSinonimos();
            for (Sinonimo s: auxS){
                if (!itensImpressos.contains(s)){
                    itensImpressos.add(s);
                    System.out.println("===================");
                    System.out.print("Palavras: ");
                    List<Palavra> auxP = s.getPalavras();
                    for (Palavra word: auxP){
                        System.out.print(word.getGrafia() + " ");
                    }
                    System.out.println("\n"+s.getSignificado());
                }
            }
        }
    }
}
