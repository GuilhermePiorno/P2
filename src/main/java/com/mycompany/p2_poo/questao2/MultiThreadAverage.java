/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p2_poo.questao2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Home
 */
public class MultiThreadAverage {
        public static void main(String[] args) throws InterruptedException, ExecutionException{
            List<Double> vetorTeste = new ArrayList<>(List.of(3.4, 5.1, 9.9, 1.2, 7.7, 2.6, 10.2, 4.4, 2.1, 5.7));
            int quantidadeThreads = 4;
            
            int start;
            int end;
            int tamanho = vetorTeste.size()/quantidadeThreads;
            
            //====Multithreading.
            //Cria executor/pool
            ExecutorService executor = Executors.newFixedThreadPool(quantidadeThreads);
            
            //Lista de futuros parciais
            List<Future<Double>> futuro = new ArrayList<>();
            
            // Cria tarefas e da submit nelas ao pool.
            for (int i = 0; i<quantidadeThreads;i++){
               start = i*tamanho;
               
               if (i != quantidadeThreads-1){
                   end = (i+1)*tamanho;
               }
               else{
                   end = vetorTeste.size();
               }

               //Cria subvetor
               List<Double> subVetor = vetorTeste.subList(start, end);

               //Cria tarefa a partir do subvetor.
               Callable<Double> tarefa = new SomaParcialCallable(subVetor);
               
               //Submit no Callable p/ threadpool.
               Future<Double> futuroParcial = executor.submit(tarefa);
               
               //Adiciona futuroParcial em lista.
               futuro.add(futuroParcial);
               
            }
            
            //Aguarda os processos a terminarem e retorna os valores em futuro.
            executor.shutdown();
            
            double mediaFinal = 0.0;
            for (Future<Double> f: futuro){
                mediaFinal += f.get();
            }
            mediaFinal /= vetorTeste.size();

            System.out.println(mediaFinal);
        }
    
}
