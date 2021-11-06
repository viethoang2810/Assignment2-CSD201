/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.csd201.bookservice;

import com.fptuni.csd201.object.Book;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author Admin
 */
public class LibarySystem implements BookService {

    private Node root;
    public Node getRoot() {
        return root;
    }

    @Override
    public boolean addBook(Book book) {
        insertBook(root, book);
        if(searchBookbyCode(book.getCode()) != null){
            return true ;
        }else{
            return false ;
        }  
    }

    @Override
    public void printBook(Book book) {
        System.out.println(book);
    }

    @Override
    public void showBook(int method) {
        if(method == 1){
            inOrder(root);
        }else if(method == 2){
            int height = maxHeightBTS(root);
            for (int i = 0; i < height; i++) {
                breadthLevel(root, i);
            }
        }
    }

    @Override
    public Book searchBookbyCode(String bookCode) {
       return searchBook(root, bookCode).getBk();
    }

    @Override
    public int countBook() {
       return count(root);
    }

    @Override
    public boolean removeBook(String bookCode) {
        deleteNode(root, bookCode);
        if(searchBook(root, bookCode) == null){
             return true ;
        }
        return false ;
    }

    @Override
    public void printAvailableBook() {
        checkAvailableBook(root);
    }

    @Override
    public void balancing() {
        balance();
    }

    @Override
    public Book searchBookbyName(String name) {
            return searchBookName(name);
    }
    public Book searchBookName( String name){
        ArrayList<Book> book = new ArrayList<>();
        inOrder2(root, book);
        for (int i = 0; i < book.size(); i++) {
            if((book.get(i).getName()).equalsIgnoreCase(name)){
                return book.get(i);
            }
        }
        return null;

    }
    
    public boolean isEmpty(){
        return root == null ;
    }
    public Node insertBook(Node tree , Book book ){
        if(isEmpty()){
            root = new Node(book) ;
            return root;
        }
        if((book.getCode()).compareTo(tree.getBk().getCode()) > 0){
            if(tree.right == null){
                tree.right = new Node(book);
            }else{
                insertBook(tree.right, book);
            }
        }else if((book.getCode()).compareTo(tree.getBk().getCode()) < 0){
            if(tree.left == null){
                tree.left = new Node(book);
            }else{
                insertBook(tree.left, book);
            }
        }
        return tree ;
    }
    public void inOrder(Node node){
        if(node == null){
            return ;
        }else{
            inOrder(node.left);
            printBook(node.getBk());
            inOrder(node.right);
        }
    }
    public Node searchBook(Node tree , String code){
        if( tree == null){
            return null;
        }
        if((tree.getBk().getCode()).equalsIgnoreCase(code) == true ){
            return tree;
        }else if(code.compareTo(tree.getBk().getCode()) > 0){
            return searchBook(tree.right, code);
        }else if((code.compareTo(tree.getBk().getCode())) < 0){
            return searchBook(tree.left, code);
        }
        return tree ;
    }
    public int count(Node tree){
        if(isEmpty() || tree == null){
            return 0 ;
        }
       return (count(tree.left) + 1 + count(tree.right));
    }
    public int maxHeightBTS(Node node) {
        if (node == null) {
            return 0;
        } else {
            int lHeight = maxHeightBTS(node.left);
            int rHeight = maxHeightBTS(node.right);
            if (lHeight > rHeight) {
                return (lHeight + 1);
            } else {
                return (rHeight + 1);
            }
        }
    }
    public void breadthLevel(Node root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            printBook(root.getBk());
        else if (level > 1) {
            breadthLevel(root.left, level - 1);
           breadthLevel(root.right, level - 1);
        }
    }
    public void deleteNode(Node node , String code){
        Node  p = searchBook(root,code);
        Node q = root ,f = null ;
        if(p == null){
            return ;
        }
        while(q != p){
            f = q ;
            if((p.getBk().getCode()).compareTo(q.getBk().getCode()) < 0 ){
                q = q.left;
            }else if((p.getBk().getCode()).compareTo(q.getBk().getCode()) > 0 ){
                q = q.right;
            }
        }
        if(p.left == null && p.right == null){
            if(f.left == p){
                f.left = null;
            }else if(f.right == p){
                f.right = null;
            }
        }else if(p.left != null && p.right == null){
            if(f.left == p){
                f.left = p.left ;
            }else if(f.right == p){
                f.right = p.left;
            }
        }else if(p.left == null && p.right != null){
            if(f.left == p){
                f.left = p.right ;
            }else if(f.right == p){
                f.right = p.right;
            }
        }else if(p.left != null && p.right != null){
            q = p.left;
            f = null;
            while (q.right != null) {
                f = q;
                q = q.right;
            }
            p.bk = q.bk;
            if (f == null) {
                p.left = q.left;
            } else {
                f.right = q.left;
            }
        }
    }
    public void checkAvailableBook(Node node){
        if(node == null){
            return ;
        }else{
            if(node.getBk().getLended() < node.getBk().getQuantity()){
                printBook(node.getBk());
            }
            checkAvailableBook(node.left);
            checkAvailableBook(node.right);
        }
    }
    public void inOrder2(Node tree , ArrayList<Book> book){
        if(tree == null){
            return  ;
        }else{
            inOrder2(tree.left, book);
            inOrder2(tree.right, book);
            book.add(tree.getBk()); 
        }
    }
    public ArrayList<Book> insertToArray(){
        ArrayList<Book> book = new ArrayList<>();
        inOrder2(root, book);
        return book ;
    }
    public void balanceTree(ArrayList<Book> book , int first,int last){
        if(first > last){
            return;
        }else{
             int middle = (first + last)/2;
             addBook(book.get(middle));
             balanceTree(book, first, middle-1);
             balanceTree(book, middle + 1, last);
        }
    }
    public void sortBook(ArrayList<Book> book){
        Collections.sort(book);
    }
    public void balance(){
        ArrayList<Book> book = new ArrayList<Book>();
        inOrder2(root, book);
        sortBook(book);
        LibarySystem tree = new LibarySystem();
        tree.balanceTree(book, 0, book.size()-1);
        root = tree.root;
    }
    
}
