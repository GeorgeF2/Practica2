/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Jorge Perez
 */
public  class Tabla {
    int alfabeto;
    int estados;
    int[] finales;
    public static String[] colum;
    public static Object[][] lista;
    
    public Tabla(int a, int b, String al, int[] finales){
        this.alfabeto=a;
        this.estados=b;
        this.finales=finales;
        colum = new String[alfabeto+1];
        lista = new Object[estados][alfabeto+1];
        for(int i=0;i<b;i++){
            this.lista[i][0]="Q"+String.valueOf(i);
        }
        this.colum[0]=" ";
        for(int i=1;i<=a;i++){
            this.colum[i]=String.valueOf(al.charAt(i-1));
        }
        
    }
    
    public static Node[] fillTable(int est, int alf, int[] fin){
        new TablaUI().setVisible(true);
        while(TablaUI.flag){
            System.out.println(" ");
            System.out.println("\b");
        }
        Node[] tree = new Node[est];
        int[][] list = new int[est][alf];
        for (int i = 0; i < est; i++) {
            for (int j = 0; j < alf; j++) {
                System.out.println(i+" "+j+"   "+Integer.parseInt(TablaUI.jTable1.getValueAt(i, j+1).toString()));
                list[i][j]=Integer.parseInt(TablaUI.jTable1.getValueAt(i, j+1).toString());
            }
            boolean yesno=false;
            for (int j = 0; j < fin.length; j++) {
                if (fin[j] == i) {
                    yesno=true;
                }
            }
            tree[i]= new Node(i, list[i], yesno);
        }
        return tree;
    }
}
