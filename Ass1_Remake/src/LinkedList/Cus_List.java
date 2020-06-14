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
public class Cus_List {
    Cus_Node head, tail;

    public Cus_List() {
        head = tail =  null;
    }
    
    boolean isEmpty(){
        return (head == null);
    }
    
    public void clear(){
        head = tail = null;
    }
    
    public int size() {
        int count = 0;
        Cus_Node p = head;
        while(p != null){
            count ++;
            p = p.next;
        }
        return count;
    }
    
    // (1) 
    public void addLast(Customer x) {
        Cus_Node q = new Cus_Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }
    
    public Customer get(int i){
        int count = 0;
        for (Cus_Node temp = head; temp != null; temp = temp.next) {
            if (count == i) {
                return temp.info;
            }
            count++;
        }
        return (null);
    }
    
    public void visit(Cus_Node p) {
        if (p != null) {
            System.out.print(p.info + " ");
        }
    }

    public void traverse() {
        Cus_Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
    }
    //delete at position k
	public void deleteAt(int k) {
        if (isEmpty()) return;
        if (k == 0) {//check if node is head
            Cus_Node p = head;
            head = head.next;
            p.next = null;
        } else {	
            Cus_Node p = pos(k);//get node position k
            if (p == null) return;
            Cus_Node q = pos(k - 1);//q is node before of p
            // Remove p
            q.next = p.next;
            p.next = null;
            if (p == tail) tail = q;
        }
    }
    public Cus_Node pos(int k) {
        int count = 0;
        for (Cus_Node temp = head; temp != null; temp = temp.next) {
            if (count == k) {
                return temp;
            }
            count++;
        }
        return (null);
    }    
}
