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
public class Bus_List {

    public Bus_Node head, tail;

    public Bus_List() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }
    
    public int size() {
        int count = 0;
        Bus_Node p = head;
        while(p != null){
            count ++;
            p = p.next;
        }
        return count;
    }

    public void addLast(Bus x) {
        Bus_Node q = new Bus_Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    public void addFirst(Bus x) {
        head = new Bus_Node(x, head);
        if (tail == null) {
            tail = head;
        }
    }

    public void visit(Bus_Node p) {
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    public void traverse() {
        Bus_Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
    }
    
    public Bus get(int i){
        int count = 0;
        for (Bus_Node temp = head; temp != null; temp = temp.next) {
            if (count == i) {
                return temp.info;
            }
            count++;
        }
        return (null);
    }

    //delete at position k
	public void deleteAt(int k) {
        if (isEmpty()) return;
        if (k == 0) {//check if node is head
            Bus_Node p = head;
            head = head.next;
            p.next = null;
        } else {	
            Bus_Node p = pos(k);//get node position k
            if (p == null) return;
            Bus_Node q = pos(k - 1);//q is node before of p
            // Remove p
            q.next = p.next;
            p.next = null;
            if (p == tail) tail = q;
        }
    }

    public void sortByBCode() {
        Bus_Node pi, pj;
        Bus x;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pj.info.getBcode().compareTo(pi.info.getBcode()) < 0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
    
    public void sortBySeat() {
        Bus_Node pi, pj;
        Bus x;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pj.info.getSeat() < pi.info.getSeat()) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    public Bus_Node pos(int k) {
        int count = 0;
        for (Bus_Node temp = head; temp != null; temp = temp.next) {
            if (count == k) {
                return temp;
            }
            count++;
        }
        return (null);
    }

    public void insertBefore(int k, Bus x) {
        Bus_Node p = new Bus_Node(x);
        Bus_Node q = pos(k);
        Bus_Node temp = head;
        if (isEmpty()) {
            head = tail = p;
        } else {
            while (temp != null && temp.next != q) {
                temp = temp.next;
            };
            temp.next = p;
            p.next = q;
        }
    }
}
