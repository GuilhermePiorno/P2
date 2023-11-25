/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.p2_poo.questao1.visual;
import com.mycompany.p2_poo.questao1.controller.Controller;
import com.mycompany.p2_poo.questao1.modelo.Dicionario;
import java.util.ArrayList;
import java.util.List;
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
        
        
        Dicionario meuDicionario = Controller.iniciaDicionario();
        
        // Cria campos de texto.
        String campoFonetica;
        String campoGrafia;
        List<String> campoSignificados = new ArrayList<>();
        
        //======================================================================
        // Preenchimento dos campos.
        campoFonetica = "lí-vro";
        campoGrafia = "livro";
        campoSignificados.add("Coleção de folhas de papel, impressas ou não, reunidas em cadernos cujos dorsos são unidos por\n" +
"meio de cola, costura etc., formando um volume que se recobre com capa resistente.");
        campoSignificados.add("Obra de cunho literário, artístico, científico etc. que constitui um volume (Para fins de\n" +
"documentação, é uma publicação não periódica com mais de 48 páginas, além da capa.).");
        
        // Botão "Adicionar palavra"
        Controller.adicionarPalavras(meuDicionario, campoFonetica, campoGrafia, campoSignificados);      
        campoSignificados.clear();
        
        
        //======================================================================
        // Preenchimento dos campos.2
        campoFonetica = "ó-bra";
        campoGrafia = "obra";
        campoSignificados.add("Aquilo que resulta de um trabalho, de uma ação.");
        campoSignificados.add("Obra de cunho literário, artístico, científico etc. que constitui um volume (Para fins de\n" +
"documentação, é uma publicação não periódica com mais de 48 páginas, além da capa.).");
        
        // Botão "Adicionar palavra"
        Controller.adicionarPalavras(meuDicionario, campoFonetica, campoGrafia, campoSignificados);
        campoSignificados.clear();
           
        //======================================================================
        
        //Consulta uma palavra especifica.
        Controller.consultaPalavra(meuDicionario, "livro");
        //Consulta uma palavra especifica.
        Controller.consultaPalavra(meuDicionario, "obra");
        
//        //Lista todas palavras do Dicionário.
//        Controller.listaTodasPalavras(meuDicionario);
        
//        //Apenas para testar funcionamento.(ignorar)
//        Controller.listaPorSignificado(meuDicionario);
    }
}
