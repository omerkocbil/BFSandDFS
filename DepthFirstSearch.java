/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmaanalizodev.bfs.dfs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author jan
 */
public class DepthFirstSearch {

    public static void main(String args[]){
        DepthFirstSearch dfs = new DepthFirstSearch(7);
 
        dfs.nodeEkle(0, 1);
        dfs.nodeEkle(0, 2);
        dfs.nodeEkle(0, 3);
        dfs.nodeEkle(0, 4);
        dfs.nodeEkle(1, 0);
        dfs.nodeEkle(1, 3);
        dfs.nodeEkle(1, 5);
        dfs.nodeEkle(2, 0);
        dfs.nodeEkle(2, 6);
        dfs.nodeEkle(3, 0);
        dfs.nodeEkle(3, 1);
        dfs.nodeEkle(3, 5);
        dfs.nodeEkle(4, 0);
        dfs.nodeEkle(4, 6);
        dfs.nodeEkle(5, 1);
        dfs.nodeEkle(5, 3);
        dfs.nodeEkle(6, 2);
        dfs.nodeEkle(6, 4);
 
        System.out.println("A --> 0, B --> 1, C --> 2, D --> 3, E --> 4, F --> 5, G --> 6 şeklinde ifade ediliyor. Arama F --> 5 numaradan başlamaktadır.");
        System.out.print("Gezinme Sırası: "); 
        
        dfs.basla(5);
    }
    
    
    int node;

    LinkedList<Integer> graph[];
 
    DepthFirstSearch(int node){
        this.node = node;
        
        graph = new LinkedList[node];
        for (int i = 0; i < node; i++) {
            graph[i] = new LinkedList();
        }
    }
 
    void nodeEkle(int node, int anotherNode) {
        graph[node].add(anotherNode);
    }
 
    void gez(int node, boolean visited[]) {
        visited[node] = true;
        int sayac = 1;
        System.out.print(node + " ");
 
        Iterator<Integer> i = graph[node].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                gez(n, visited);
            }
        }
    }
 
    void basla(int node) {
        boolean visited[] = new boolean[this.node];

        gez(node, visited);
    }
    
}
