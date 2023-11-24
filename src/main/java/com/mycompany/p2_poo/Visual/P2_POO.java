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

 // comentário geral para todas as classes modelo: ele pode querer que os nomes das variáveis do programa sigam o modelo definido
 // no diagrama UML. Então na classe Palavra, por exemplo, a lista de sinônimos não poderia se chamar "listaSinonimos", mas 
 // sim "sinonimos". Eu acho isso ruim, porque eu achei os nomes que ele escolheu para as classes meio confusos, mas pode ser que 
 // ele cobre isso.
 public class P2_POO {

    public static void main(String[] args) {
        System.out.println("Bem vindo ao dicionário mais limitado do universo.\n");
        System.out.println("Frase do dia:");
        System.out.println("\"If you could say it in words, there would be no reason to paint.");
        System.out.println("                                                    -Edward Hopper");
        
        Set<String> significados = new HashSet<>();
        // aqui eu também tenho dúvida: eu não sei se ele aceita que as classes visão criem estruturas. Por exemplo, eu não sei se
        // ele quer que cada significado seja inserido um de cada vez por uma função do tipo 
        // adicionaPalavra(Dicionario dicionario, String fonetica, String grafia, String significado) ou se ele aceitaria criar um 
        // conjunto na view e então inserir a palavra junto com todos os seus significados, ou se ele aceitaria qualquer uma das duas

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
