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
public class Rota {

    private int cid1, cid2, dist, usada;

    public Rota() {

    }

    public Rota(int cid1, int cid2, int dist) {
        this.cid1 = cid1;
        this.cid2 = cid2;
        this.dist = dist;
        usada = 0;
    }

    public ArrayList<Rota> criarRotas(int[][] matriz) {
        Rota r;
        ArrayList<Rota> rotas = new ArrayList();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i != j && matriz[i][j] != 0) {
                    r = new Rota(i, j, matriz[i][j]);
                    rotas.add(r);
                }
            }
        }
        return rotas;
    }

    public int getCid1() {
        return cid1;
    }

    public int getUsada() {
        return usada;
    }

    public void setUsada(int usada) {
        this.usada = usada;
    }

    public int getCid2() {
        return cid2;
    }

    public int getDist() {
        return dist;
    }
}
