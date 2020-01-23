package com.algorithm;

public class QuickSort {

    public void quickSort(int [] A,int l,int r){
        if (l<r){
            int pi=partition(A, l, r);
            quickSort(A,l,pi);
            quickSort(A,pi+1,r);
        }
    }
    public  int getFirstPivot(int l , int r){
        return l;
    }
    public  int getLastPivot(int l , int r){
        return r;
    }
    public  int getMedianPivot(int l , int r){
        return r;
    }

    public int partition(int[]A,int l,int r){
        int pi = A[l];
        int i=l+1;
        for (int j=l+1;j<=r;j++){
            System.out.println(">>>>"+j);
            if (A[j]<pi){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i=i+1;
            }
        }
        int temp = A[i-1];
        A[i-1] = A[l];
        A[l] = temp;
        return i-1;
    }

    public int choosePivot(int [] A,int n){
        return A[0];
    }

    public void swap(int []A,int p,int q){
        int temp=A[p];
        A[p]=A[q];
        A[q]=temp;
    }
}
