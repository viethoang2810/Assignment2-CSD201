/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.csd201.bookservice;

import com.fptuni.csd201.object.Book;

/**
 *
 * @author Admin
 */
public class Node {
    Book bk;
    Node left ;
    Node right  ;
    public Node() {
        
    }

    public Node(Book bk) {
        this.bk = bk;
    }

    public Book getBk() {
        return bk;
    }

    public void setBk(Book bk) {
        this.bk = bk;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    
    
}
