/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author cuongnm
 * @param <E>
 */
public class Node<E> {

    public E info;
    public Node<E> next;

    public Node() {
    }

    public Node(E info, Node<E> next) {
        this.info = info;
        this.next = next;
    }

    public Node(E info) {
        this.info = info;
        this.next = null;
    }
}
