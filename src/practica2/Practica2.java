/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;


import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge Perez
 */
public class Practica2 {

    /**
     * @param args the command line arguments
     */
    static boolean flag;
    
    public static void main(String[] args) {
        // TODO code application logic here
        String alfabeto = getAlphabet();
        Map<Character, Integer> alfa = new HashMap<>();
        int j=0;
        for(char c : alfabeto.toCharArray()){
            alfa.put(c, j);
            j++;
        }
        int estados = getState();
        int[] finales = getFinal(estados);
        
        print(alfabeto, estados, finales);
        System.out.println(alfabeto.length());
        Tabla a = new Tabla(alfabeto.length(),estados,alfabeto, finales);
        
        Node[] tree = Tabla.fillTable(estados, alfabeto.length(),finales);
        for (int i = 0; i < tree.length; i++) {
            tree[i].printNode();
        }
        boolean sudo=true;
        do{
            String w= getWord();
            if (w.contains("exit")) {
                sudo = false;
                System.exit(0);
            }
            int current=0;
            boolean finn = tree[0].isEnd();
            for(char c : w.toCharArray()){
                current = tree[current].getNext(alfa.get(c));
                finn=tree[current].isEnd();
            }
            if (finn) {
                System.out.println("si pertenece");
                JOptionPane.showMessageDialog(null, "'w' Si Pertenece");
            }
            else{
                System.out.println("no pertenece");
                JOptionPane.showMessageDialog(null, "'w' No Pertenece");
            }
        }while(sudo);
        System.exit(0);
    }
    
    public static void print(String alfabeto, int estados, int[] finales){
        System.out.print("Alfabeto: "+alfabeto+"\nEstados: ");
        for(int i=0;i<estados;i++){
            System.out.print("Q"+i+", ");
        }
        System.out.print("\b\b\nEstado inicial: Q0\nEstados finales: ");
        for(int i=0;i<finales.length;i++){
                System.out.print("Q"+finales[i]+", ");
        }
        System.out.print("\b\b\n");
    }
    
    public static String getWord(){
        String intro = JOptionPane.showInputDialog("w:");
        
        return intro;
    }
    
    public static String getAlphabet(){
        String intro = JOptionPane.showInputDialog("Alfabeto:");
        String alfabeto = null;
        for(char c : intro.toCharArray()){
            if(c!=','&&c!=' ')
                if(alfabeto!=null)
                    alfabeto += c;
                else
                    alfabeto=String.valueOf(c);
        }
        return alfabeto;
    }
    
    public static int getState(){
        int estados = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de estados:"));
        
        return estados;
    }
    
    public static int[] getFinal(int n){
        String intro = JOptionPane.showInputDialog("Numeros de los estados finales:");
        int[] finales = new int[n];
        String temp=null;
        int i=0;
        for(char c : intro.toCharArray()){
            if(c!=','&&c!=' ')
                if(temp==null)
                    temp=String.valueOf(c);
                else
                    temp += c;
            else if(c==','){
                finales[i]=Integer.parseInt(temp);
                i++;
                temp=null;
            }
          
        }
        finales[i]=Integer.parseInt(temp);
        int[] truee = new int[i+1];
        for (int j = 0; j < i+1; j++) {
            truee[j]=finales[j];
        }
        return truee;
    }
    
    
}
