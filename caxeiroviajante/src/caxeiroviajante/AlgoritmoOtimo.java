/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caxeiroviajante;

import java.util.ArrayList;

/**
 *
 * @author cassi
 */
public class AlgoritmoOtimo {

    private int[][] matriz;
    private int cont, melhorcaminho;
    private int[] melhorvetor;

    public AlgoritmoOtimo(int[][] m) {
        matriz = m;
        melhorcaminho = Integer.MAX_VALUE / 2;
    }

    public void troca(int vetor[], int i, int j) {
        int t;
        t = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = t;
    }

    public void RotacaoEsquerda(int[] vetor, int comeco) {
        int tmp = vetor[comeco];
        for (int i = comeco; i < vetor.length - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        vetor[vetor.length - 1] = tmp;
    }

    public void calculoCaminho(int[] vetor) {
        int caminho = 0;
        for (int i = 1; i < vetor.length; i++) {
            caminho = caminho + matriz[vetor[i - 1]][vetor[i]];
        }
        caminho = caminho + matriz[vetor[vetor.length - 1]][vetor[0]];
        if (caminho < melhorcaminho) {
            melhorcaminho = caminho;
            melhorvetor = vetor.clone();
        }
    }

    public void permutacao(int[] vetor, int comeco) {
        if (comeco < vetor.length) {
            int i, j;
            for (i = vetor.length - 2; i >= comeco; i--) {
                for (j = i + 1; j < vetor.length; j++) {
                    troca(vetor, i, j);
                    permutacao(vetor, i + 1);
                }
                RotacaoEsquerda(vetor, i);
            }
        }
        calculoCaminho(vetor);
    }

    public void imprime() {
        System.out.print("Melhor caminho: ");
        for (int i = 0; i < melhorvetor.length; i++) {
            System.out.print(melhorvetor[i]+" ");
        }
        System.out.print(melhorvetor[0]);
        System.out.println("\nCusto do melhor caminho: " + melhorcaminho);
    }
}
