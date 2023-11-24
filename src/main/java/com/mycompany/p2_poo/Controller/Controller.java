/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p2_poo.Controller;

import com.mycompany.p2_poo.Modelo.Dicionario;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Home
 */
public class Controller {
    
   //Cria dicionario
   public static Dicionario IniciaDicionario(){
       Dicionario dic = new Dicionario();
       return dic;
   }
   
   public static void AdicionarPalavras(Dicionario dic, String fonetica, String grafia, Set significados){
       dic.adiciona(fonetica, grafia, significados);
   }
   
   public static void ListaItens(Dicionario dic){
       dic.ListaItens();
   }
   
   //Apenas para testar funcionamento.(ignorar)
   public static void ListaPorSignificado(Dicionario dic){
       dic.ListaPorSignificado();
   }
   
   
}
