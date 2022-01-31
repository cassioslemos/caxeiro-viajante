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
public class ArvoreMinima {

    private int[][] matriz;

    public ArvoreMinima(int[][] matriz) {
        this.matriz = matriz;
    }

    public ArrayList<Rota> CriarArvoreMaxima(ArrayList<Rota> r) {
        int menorrota = Integer.MAX_VALUE / 2;
        Rota rota = new Rota();
        ArrayList<Rota> rotas = new ArrayList();
        for (int i = 0; i < r.size(); i++) {
            for (int j = 0; j < r.size(); j++) {
                if (r.get(j).getDist() < menorrota && rotas.contains(r.get(j)) != true && r.get(j).getUsada() != 1) {
                    menorrota = r.get(j).getDist();
                    rota = r.get(j);
                }
            }
//              System.out.println(rota.getCid1());
            menorrota = Integer.MAX_VALUE / 2;
            if (rotas.size() == 0) {
                rotas.add(rota);
            } else {
                for (int j = 0; j < rotas.size(); j++) {
                    if (rota.getCid1() == rotas.get(j).getCid2() && rota.getCid2() == rotas.get(j).getCid1()) {
                        rota.setUsada(1);
                    }
                }
                if (rota.getUsada() == 0) {
                    rotas.add(rota);
                }

            }
        }
//        System.out.println(rotas.size());
//        for (int i = 0; i < rotas.size(); i++) {
//            System.out.println("Cidade 1:" + rotas.get(i).getCid1());
//            System.out.println("Cidade 2:" + rotas.get(i).getCid2());
//        }
        return rotas;
    }

    public ArrayList<Rota> criarArvoreMinima(ArrayList<Rota> arvoremaxima) {
        ArrayList<Rota> arvoreminima = new ArrayList();
        ArrayList<Integer> visitados = new ArrayList();
        arvoreminima.add(arvoremaxima.get(0));
        visitados.add(arvoremaxima.get(0).getCid1());
        visitados.add(arvoremaxima.get(0).getCid2());
        while (visitados.size() != matriz.length) {
            for (int i = 0; i < arvoremaxima.size(); i++) {
                if (arvoreminima.contains(arvoremaxima.get(i)) != true) {
                    if ((visitados.contains(arvoremaxima.get(i).getCid1()) == true && visitados.contains(arvoremaxima.get(i).getCid2()) != true) || (visitados.contains(arvoremaxima.get(i).getCid2()) == true && visitados.contains(arvoremaxima.get(i).getCid1()) != true)) {
                        arvoreminima.add(arvoremaxima.get(i));
                        if (visitados.contains(arvoremaxima.get(i).getCid1()) != true) {
                            visitados.add(arvoremaxima.get(i).getCid1());
                        }
                        if (visitados.contains(arvoremaxima.get(i).getCid2()) != true) {
                            visitados.add(arvoremaxima.get(i).getCid2());
                        }
                        break;
                    }
                }
            }
        }
//        for (int i = 0; i < arvoreminima.size(); i++) {
//            System.out.println("Cidade 1:" + arvoreminima.get(i).getCid1());
//            System.out.println("Cidade 2:" + arvoreminima.get(i).getCid2());
//        }
        return arvoreminima;
    }
}
