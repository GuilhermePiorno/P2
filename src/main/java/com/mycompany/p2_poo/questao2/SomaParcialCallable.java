/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p2_poo.questao2;

import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 * @author Home
 */
public class SomaParcialCallable implements Callable<Double>{
    private List<Double> subVetor;
    
    public SomaParcialCallable(List<Double> vetor){
        this.subVetor = vetor;
    }
    
    @Override
    public Double call(){
        double sum = 0.0;
        for (double v:subVetor){
            sum += v;
        }
        return sum;
    }
}
