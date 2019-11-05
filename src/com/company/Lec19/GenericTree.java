package com.company.Lec19;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {

    private Node root;

    public void insert(Scanner s){

        System.out.println("Enter the value of root");
        int n=s.nextInt();
        this.root=new Node(n);
        insert(s,root);
    }

    private void insert(Scanner s, Node node) {

        while(true){

            System.out.println("Do you want to add child"+node.value);
            boolean yes =s.nextBoolean();

            if(yes){

                System.out.println("Enter the value of child");
                int p=s.nextInt();
                Node child= new Node(p);
                node.children.add(child);
                insert(s,child);
            }

            else{
                break;
            }
        }
    }

    public void display(){
        display(root,"");
    }

    private void display(Node node, String indent) {

        System.out.println(indent+node.value);
        for (int i = 0; i <node.children.size() ; i++) {
            display(node.children.get(i),indent+"\t");
        }

    }

    public int count() {
        return count(root);
    }

    private int count(Node node) {
        int count=1;
        for (int i = 0; i <node.children.size() ; i++) {

            count+=count(node.children.get(i));
        }
        return count;
    }

    public int maxnode(){
        int max =root.value;
        return  maxnode(max,root);
    }

    private int maxnode(int max, Node node) {

        if(max<node.value){
            max=node.value;

        }

        for (int i = 0; i <node.children.size() ; i++) {

            max=maxnode(max,node.children.get(i));
        }
        return max;
    }

    private class Node{

        private int value;
        private ArrayList<Node> children;

        public Node(int value){

            this.value=value;
            this.children=new ArrayList<>();
        }
    }
}
