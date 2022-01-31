/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caxeiroviajante;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author cassi
 */
public class Leitor {

    private ArrayList<String> linha;

    public Leitor() {
        linha = new ArrayList();
    }

    public void LerArquivo(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        linha.add("");
        for (int i = 0; linha.get(i) != null; i++) {
            linha.add(i, buffRead.readLine());
            if (linha.get(i) != null) {
                //System.out.println(linha.get(i));

            } else {
                break;
            }
        }
        buffRead.close();
    }

    public int[] CriarVetor(int l) {
        String[] array;
        if (linha.get(0).charAt(1) == '	') {
            array = linha.get(l).split("	");
        } else {
            array = linha.get(l).split(" ");
        }
        ArrayList<String> aux = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo("") != 0) {
                aux.add(array[i]);
            }
        }

        int vetor[] = new int[aux.size()];
        for (int i = 0; i < aux.size(); i++) {
            vetor[i] = Integer.parseInt(aux.get(i));
        }
        return vetor;
    }

    int getLinhas() {
        return linha.size() - 2;
    }
}
