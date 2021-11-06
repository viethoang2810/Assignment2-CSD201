/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.csd201.lib;

/**
 *
 * @author DUNGHUYNH
 */
public class BinaryTree {
    private NodeTree root ;

    public NodeTree getRoot() {
        return root;
    }
    public boolean isEmpty(){
        return root == null ;
    }
    public void clear(){
        root = null ;
    }
    public void insert(int x ){
        root = insertNode(root, x);
    }
    public NodeTree insertNode(NodeTree treeNode , int info){
        if (isEmpty()) {
            root = new NodeTree(info);
            return root;
        }
        if (info < treeNode.infor) {
            if (treeNode.left == null) {
                treeNode.left = new NodeTree(info);
            } else {
                insertNode(treeNode.left, info);
            }
        } else {
            if (treeNode.right == null) {
                treeNode.right = new NodeTree(info );
            } else {
                insertNode(treeNode.right, info);
            }

        }
        return treeNode;
    }
    
    
    public void preOrder(NodeTree node){
        if(node == null){
            return ;
        }else{
            System.out.println(node.infor+" ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public void inOrder(NodeTree node){
        if(node == null){
            return ;
        }else{
            inOrder(node.left);
            System.out.println(node.infor+" ");
            inOrder(node.right);
        }
    }
    public NodeTree search(NodeTree root ,int x){
        if(root == null) {
            return null ;
        }
        if(x == root.infor ){
            return root ;
        }else if(x < root.infor){
            search(root.left, x) ;
        }else if(x > root.infor){
            search(root.right, x);
        }
        return root ;
    }
    public int countNode(NodeTree node){
        if(node == null){
            return  0 ;
        }else{
            return (countNode(node.left) + 1 +countNode(node.right));
        }
    }
    public int maxNode(NodeTree node){
        if(node.right == null){
            return node.infor;
        }else{
            return maxNode(node.right);
        }
    }
    public int minNode(NodeTree node){
        if(node.left == null){
            return node.infor;
        }else{
            return minNode(node.left);
        }
    }
    public int sumValue( NodeTree tree ){ 
        int sum = 0 ;
        
        if(tree == null){
            return 0 ;
        }else{
            return sum = (sumValue(tree.left) + sumValue(tree.right) + tree.infor) ;
        }
    }
    public double average(){
        double a = countNode(root);
        double b = sumValue(root);
        double avg = b/a ;
        return avg ;
    }
    public void postorder(NodeTree node){
        if(node == null){
            return ;
        }else{
            postorder(node.left);
            postorder(node.right);
            System.out.println( node.getInfor() + "");
        }
    }
    public int findMaxHeight(NodeTree node){
        if(node == null){
            return 0 ;
        }
        int leftHeight = countNode(node.left);
        int rightHeight = countNode(node.right);
        if(leftHeight > rightHeight){
            return (leftHeight - 1);
        }else{
            return (rightHeight - 1);
        }
    }
    public boolean checkAVLTree(NodeTree node){
        int leftHeight = countNode(node.left);
        int rightHeight = countNode(node.right);
        int difference = leftHeight - rightHeight;
        if(difference < -1 || difference > 1 ){
            return false ;
        }
        return true ; 
    }
    public void AVLTree(){
        if(checkAVLTree(root) == true){
            System.out.println("This is AVL tree");
            return ;
        }
        System.out.println("This is not a AVL tree");
    }
    public boolean checkHeapTree(NodeTree node){
        if(checkAVLTree(node) == true){
            if(node.left.getInfor() < node.getInfor() && node.right.getInfor() < node.getInfor()){
                checkHeapTree(node.left);
                checkHeapTree(node.right);
                return true ;
            }
        }
        return false ;
    }
    public void heapTree(){
        if(checkHeapTree(root) == true ){
            System.out.println("This is a heap tree");
            return ;
        }
        System.out.println("This is not a heap tree");
    }
}
