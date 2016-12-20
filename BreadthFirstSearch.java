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
public class BreadthFirstSearch {
    
    public static void main(String args[]){
        BreadthFirstSearch bfs = new BreadthFirstSearch(7);
 
        bfs.nodeEkle(0, 1);
        bfs.nodeEkle(0, 2);
        bfs.nodeEkle(0, 3);
        bfs.nodeEkle(0, 4);
        bfs.nodeEkle(1, 0);
        bfs.nodeEkle(1, 3);
        bfs.nodeEkle(1, 5);
        bfs.nodeEkle(2, 0);
        bfs.nodeEkle(2, 6);
        bfs.nodeEkle(3, 0);
        bfs.nodeEkle(3, 1);
        bfs.nodeEkle(3, 5);
        bfs.nodeEkle(4, 0);
        bfs.nodeEkle(4, 6);
        bfs.nodeEkle(5, 1);
        bfs.nodeEkle(5, 3);
        bfs.nodeEkle(6, 2);
        bfs.nodeEkle(6, 4);
 
        System.out.println("A --> 0, B --> 1, C --> 2, D --> 3, E --> 4, F --> 5, G --> 6 şeklinde ifade ediliyor. Arama F --> 5 numaradan başlamaktadır.");
        System.out.print("Gezinme Sırası: "); 
        
        bfs.gezin(5);
    }
    
    
    int node;

    LinkedList<Integer> graph[];
 
    BreadthFirstSearch(int node){
        this.node = node;
        
        graph = new LinkedList[node];
        for (int i = 0; i < node; i++) {
            graph[i] = new LinkedList();
        }
    }
 
    void nodeEkle(int node, int anotherNode) {
        graph[node].add(anotherNode);
    }
 
    void gezin(int s) {
        boolean visited[] = new boolean[node];
 
        LinkedList<Integer> queue = new LinkedList<>();
 
        visited[s] = true;
        queue.add(s);
 
        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");
 
            Iterator<Integer> i = graph[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
    
}
