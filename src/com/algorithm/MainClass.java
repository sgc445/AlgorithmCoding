package com.algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class MainClass  {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\sunil.gc\\IdeaProjects\\AlgorithmCoding\\src\\com\\algorithm\\quick.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        LinkedList<Integer> l =new LinkedList<Integer>();
        String st;
   /*     while ((st = br.readLine()) != null)
            l.add(Integer.parseInt(st));*/
        //int[] array = l.stream().mapToInt(i->i).toArray();
        int[] array = {100,10, 80, 30, 90, 40, 50, 70};
        QuickSort q = new QuickSort();
        System.out.println(array.length);
        q.quickSort(array,0,array.length-1);
        for (int k=0;k<array.length;k++){
            System.out.println(array[k]);
        }
        /*String st;
        LinkedList<Integer> l =new LinkedList<Integer>();
        int arr[] = new int[100000];
        while ((st = br.readLine()) != null)
           l.add(Integer.parseInt(st));
        System.out.println(l.size());
        int inv_count = 0;
        int n=l.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++) {
                if (l.get(i) > l.get(j)) {
                    inv_count++;
                    System.out.println(inv_count);
                }
            }

        System.out.println(inv_count);*/
    }


    }
