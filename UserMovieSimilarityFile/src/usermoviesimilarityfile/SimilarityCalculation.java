/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermoviesimilarityfile;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Faisal Ahmed
 */
public class SimilarityCalculation {

    public void Calc(double mat[][], int r, int c, int userId) throws IOException {
        File file = new File("Generated Output.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        double[] d = new double[r + 4];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                d[i] += mat[i][j] * mat[i][j];
            }
            d[i] = java.lang.Math.sqrt(d[i]);
        }
        double arrSim[] = new double[r];
        double arrSim2[] = new double[r];
        writer.write(String.format("Recommended Movies for User %d%n", userId));
        double maan;
        int i, j;
        userId--;
        for (i = 0; i < r; i++) {
            maan = 0;
            if (i == userId) {
                arrSim[i] = 0;
                continue;
            }
            for (j = 0; j < c; j++) {
                maan += mat[userId][j] * mat[i][j];
            }
            if (d[userId] > 0. && d[i] > 0.) {
                maan = maan / (d[userId] * d[i]);
            } else {
                maan = 0.;
            }
            arrSim[i] = arrSim2[i] = maan;
        }

        Arrays.sort(arrSim2);
        int cnt = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (i = r - 1; i >= 0; i--) {
            cnt++;
            if (cnt == 6) {
                break;
            }
            if (i != r - 1 && arrSim2[i] == arrSim2[i + 1]) {
                continue;
            }
            for (j = 0; j < r; j++) {
                if (arrSim2[i] == arrSim[j]) {
                    for (int k = 0; k < c; k++) {
                        if (mat[j][k] > 0) {
                             set.add(k);
                        }
                    }
                }
            }
        }
        TreeSet sortedSet = new TreeSet<Integer>(set);
        Iterator iterator = sortedSet.iterator();
        while(iterator.hasNext()){
        writer.write(String.format("%d%n",iterator.next()));
        }
        writer.flush();
        writer.close();
        JOptionPane.showMessageDialog(null, "Output is Generated");
        return;
    }
}
