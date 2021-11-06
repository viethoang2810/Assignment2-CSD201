/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.csd201.lib;

/**
 *
 * @author Admin
 */
public class NodeTree {
    int infor ;
    NodeTree left ;
    NodeTree right  ;
    public NodeTree() {
        
    }

    NodeTree(int infor) {
        this.infor = infor;
    } 

    public int getInfor() {
        return infor;
    }

    public void setInfor(int infor) {
        this.infor = infor;
    }
    
//    @Override
//    public String toString() {
//        return "{Root: " + infor + "\nLeft: " + left + " Right: " +right+"}" ;
//    }
    
}
