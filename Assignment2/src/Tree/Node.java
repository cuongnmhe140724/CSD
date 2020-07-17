/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import Entity.Bus;

/**
 *
 * @author cuongnm
 */
public class Node {
    public Bus info;
    public Node left;
    public Node right;

    public Node() {
    }
    
    public Node(Bus info){
        this.info = info;
        left = right = null;
    }
}
