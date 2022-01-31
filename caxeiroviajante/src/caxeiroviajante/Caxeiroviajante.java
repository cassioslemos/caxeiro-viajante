/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caxeiroviajante;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author cassi
 */
public class Caxeiroviajante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Leitor l = new Leitor();
        int aux[];
        int matriz[][];
        l.LerArquivo("src\\caxeiroviajante\\tsp5_27603.txt");
        aux = l.CriarVetor(0);
        matriz = new int[l.getLinhas()][aux.length];
        matriz[0] = aux;
        for (int i = 1; i < l.getLinhas(); i++) {
            matriz[i] = l.CriarVetor(i);
        }
        //imprime matriz
//        for(int i=0; i<matriz.length; i++){
//            for(int j=0; j<matriz[i].length;j++){
//                System.out.print(matriz[i][j]+" ");
//            }
//            System.out.print("\n");
//        }
//chama algoritmo força bruta
//        AlgoritmoOtimo ao = new AlgoritmoOtimo(matriz);
//        int vetor[] = new int [matriz.length];
//        for(int i=0;i<vetor.length;i++){
//            vetor[i]=i;
//        }
//        ao.calculoCaminho(vetor);
//        ao.permutacao(vetor, 0);
//        ao.imprime();
//chama algoritmo aproximativo
        Rota r = new Rota();
        ArrayList<Rota> rotas;
        ArrayList<Rota> arvoremaxima, arvoreminima;
        rotas = r.criarRotas(matriz);
        ArvoreMinima a = new ArvoreMinima(matriz);
        arvoremaxima = a.CriarArvoreMaxima(rotas);
        arvoreminima = a.criarArvoreMinima(arvoremaxima);
        CicloHamiltoniano ch = new CicloHamiltoniano(matriz);
        ch.gerarCaminho(arvoreminima);
    }

}
