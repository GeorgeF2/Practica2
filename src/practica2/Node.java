/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

/**
 *
 * @author japt
 */
public class Node {
    int id;
    int[] des;
    boolean end;
    
    public Node(int id, int[] alfa, boolean end){
        this.id=id;
        this.des=alfa;
        this.end=end;
    }
    
    public int getNext(int alfa){
        return this.des[alfa];
    }
    
    public boolean isEnd(){
        return end;
    }
    public void printNode(){
        System.out.println("Maquina #"+id);
        for (int i = 0; i < des.length; i++) {
            System.out.println("Si '"+i+"' ir a: "+des[i]);
        }
        if (end) {
            System.out.println("Es final");
        }
        else{
            System.out.println("no es linal");
        }
    }
}
