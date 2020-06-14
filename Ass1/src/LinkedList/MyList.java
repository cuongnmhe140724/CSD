/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author cuongnm
 */
public class MyList<E> {

    Node<E> head, tail;

    public void myList() {
        head = tail = null;
    }

    // check linked is empty or not
    public boolean isEmpty() {
        return (head == null);
    }

    // clear linked list
    public void clear() {
        head = tail = null;
    }

    public void addLast(E x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    public void addFirst(E x) {
        head = new Node(x, head);
        if (tail == null) {
            tail = head;
        }
    }
    // size of list
    public int size() {
        int count = 0;
        Node p = head;
        while(p != null){
            count ++;
            p = p.next;
        }
        return count;
    }
    //search p return node
    public Node pos(int k) {
        int count = 0;
        for (Node temp = head; temp != null; temp = temp.next) {
            if (count == k) {
                return temp;
            }
            count++;
        }
        return (null);
    }
    //print out node
    public void visit(Node p) {
        if (p != null) {
            System.out.print(p.info);
        }
    }

    public void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }
    
    //dele node
    public void dele(Node q){
		Node f,p; 
		f=null;
		p=head;
		while(p!=null){
			if(p==q) break;
			f=p;
			p=p.next;
		}
		if(p==null) return;
		if(f==null){
			head=head.next;
			if(head==null) tail=null;
			return;
		}
		f.next=p.next;
		if(f.next==null) tail=f;
	 }
}
