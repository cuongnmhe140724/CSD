/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import Entity.Bus;

/**
 *
 * @author cuongnm
 */
public class Bus_Node {
    Bus info;
    Bus_Node next;

    public Bus_Node(Bus x, Bus_Node p) {
        info = x;
        next = p;
    }
    
    public Bus_Node(Bus x){
        this(x,null);
    }
    
}
