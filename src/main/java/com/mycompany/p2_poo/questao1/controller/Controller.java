/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p2_poo.questao1.controller;

import com.mycompany.p2_poo.questao1.modelo.Dicionario;
import java.util.List;


// as validações devem ser feitas no Controller (se a palavra pode ser inserida ou se ela já existe, etc)
public class Controller {
    
   //Cria dicionario
   public static Dicionario iniciaDicionario(){
       Dicionario dic = new Dicionario();
       return dic;
   }
   
   public static void adicionarPalavras(Dicionario dic, String fonetica, String grafia, List<String> significados){
       if (dic.buscaPalavra(grafia) == null){
           dic.adiciona(fonetica, grafia, significados);
       }
   }
   
   public static void consultaPalavra(Dicionario dic, String consulta){
       dic.consultaPalavra(consulta);
   }
   
   public static void listaTodasPalavras(Dicionario dic){
       dic.listaTodasPalavras();
   }
   
   //Apenas para testar funcionamento.(ignorar)
   public static void listaPorSignificado(Dicionario dic){
       dic.listaPorSignificado();
   }   
   
}
