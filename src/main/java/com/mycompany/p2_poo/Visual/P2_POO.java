/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.p2_poo.Visual;
import com.mycompany.p2_poo.Controller.Controller;
import com.mycompany.p2_poo.Modelo.Dicionario;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 *
 * @author Home
 */
public class P2_POO {

    public static void main(String[] args) {
        System.out.println("Bem vindo ao dicionário mais limitado do universo.\n");
        System.out.println("Frase do dia:");
        System.out.println("\"If you could say it in words, there would be no reason to paint.");
        System.out.println("                                                    -Edward Hopper");
        
        Set<String> significados = new HashSet<>();
        Dicionario MeuDicionario = Controller.IniciaDicionario();
        
        String fonetica = "lí-vro";
        String grafia = "livro";
        significados.add("Coleção de folhas de papel, impressas ou não, reunidas em cadernos cujos dorsos são unidos por\n" +
"meio de cola, costura etc., formando um volume que se recobre com capa resistente.");
        significados.add("Obra de cunho literário, artístico, científico etc. que constitui um volume (Para fins de\n" +
"documentação, é uma publicação não periódica com mais de 48 páginas, além da capa.).");
        Controller.AdicionarPalavras(MeuDicionario, fonetica, grafia, significados);      
        
        
        fonetica = "ó-bra";
        grafia = "obra";
        significados.clear();
        significados.add("Aquilo que resulta de um trabalho, de uma ação.");
        significados.add("Obra de cunho literário, artístico, científico etc. que constitui um volume (Para fins de\n" +
"documentação, é uma publicação não periódica com mais de 48 páginas, além da capa.).");
        
        
        Controller.AdicionarPalavras(MeuDicionario, fonetica, grafia, significados);
        Controller.ListaItens(MeuDicionario);
        
        //Apenas para testar funcionamento.(ignorar)
//        Controller.ListaPorSignificado(MeuDicionario);
    }
}
