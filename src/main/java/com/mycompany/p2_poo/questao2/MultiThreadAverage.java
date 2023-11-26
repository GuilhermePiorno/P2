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
    
    public static double multiThreadingAverage(List<Double> vetor, int nThreads) throws InterruptedException, ExecutionException{
        int start;
        int end;
        int tamanho = vetor.size()/nThreads;
        
        //====Multithreading.
        //Cria executor/pool
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        
        //Lista de futuros parciais
        List<Future<Double>> colecaoFuturos = new ArrayList<>();
        
        // Cria tarefas e da submit nelas ao pool.
        for (int i = 0; i < nThreads; i++){
            start = i*tamanho;
            if (i != nThreads-1){
                end = (i+1)*tamanho; // sem -1 por causa de subList
            }
            else{
                end = vetor.size(); // sem -1 por causa de subList
            }
            
            //Cria subvetor
            List<Double> subVetor = vetor.subList(start, end);
            
            //Cria tarefa a partir do subvetor.
            Callable<Double> tarefa = new SomaParcialCallable(subVetor);
            
            //Submit no Callable p/ threadpool.
            Future<Double> futuroParcial = executor.submit(tarefa);
            
            //Adiciona futuroParcial em lista.
            colecaoFuturos.add(futuroParcial);
        }
        //Aguarda os processos a terminarem e retorna os valores em futuro.
        executor.shutdown();
        
        double mediaFinal = 0.0;
        for (Future<Double> f: colecaoFuturos){
            mediaFinal += f.get();
        }
        mediaFinal /= vetor.size();
        
        return mediaFinal;
        
    }
}
