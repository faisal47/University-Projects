/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usersmovieratingsimilarity;

/**
 *
 * @author Faisal Ahmed
 */
public class SimilarityCalculation {
    public boolean Calc(int mat[][]){
//    for(int i=0;i<3;i++)
//    for(int j=0;j<4;j++)
//        System.out.println(mat[i][j]);
    boolean res=true;
    double[] d = new double[3];
    for(int i=0;i<3;i++)
    for(int j=0;j<4;j++)
        d[i]+=mat[i][j] * mat[i][j];
    for(int i=0;i<3;i++)
    d[i]= java.lang.Math.sqrt(d[i]);
    
    double dif1,dif2;
    dif1=dif2=0;
    for(int i=0;i<4;i++)
    dif1+=(mat[0][i] * mat[1][i]);
    for(int i=0;i<4;i++)
    dif2+=(mat[0][i] * mat[2][i]);
    if(d[0] >0 && d[1]>0)
    dif1/=(d[0] * d[1]);
    else
       dif1=-10000;
    if(d[0] >0 && d[2]>0)
    dif2/=(d[0] * d[2]);
    else
       dif2=-10000;
    
    if(dif2 > dif1)
        res=false;
    
    return res;    
    }
}
