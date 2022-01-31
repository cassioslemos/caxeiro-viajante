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
public class CicloHamiltoniano {

    private int[][] matriz;

    public CicloHamiltoniano(int[][] matriz) {
        this.matriz = matriz;
    }

    public void gerarCaminho(ArrayList<Rota> arvoreminima) {
        ArrayList<Integer> caminho = new ArrayList();
        for (int i = 0; i < arvoreminima.size(); i++) {
            caminho.add(arvoreminima.get(i).getCid1());
            caminho.add(arvoreminima.get(i).getCid2());
        }
        for (int i = 0; i < caminho.size(); i++) {
            for (int j = 0; j < caminho.size(); j++) {
                if (i != j && caminho.get(i) == caminho.get(j)) {
                    caminho.remove(j);
                }
            }
        }
        caminho.add(caminho.get(0));
        int resultado = 0;
        for (int i = 0; i < caminho.size() - 1; i++) {
            resultado = resultado + matriz[caminho.get(i)][caminho.get(i + 1)];
        }
        System.out.print("Melhor caminho encontrado: ");
        for (int i = 0; i < caminho.size(); i++) {
            System.out.print(caminho.get(i) + " ");
        }
        System.out.println("\nCusto do melhor caminho encontrado: " + resultado);
    }
}
