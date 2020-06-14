/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import Entity.Customer;

/**
 *
 * @author cuongnm
 */
public class Cus_Node {
    Customer info;
    Cus_Node next;

    public Cus_Node(Customer x, Cus_Node p) {
        info = x;
        next = p;
    }
    
    public Cus_Node(Customer x){
        this(x,null);
    }
    
}
