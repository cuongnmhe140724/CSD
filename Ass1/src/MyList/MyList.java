/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyList;

/**
 *
 * @author cuongnm
 * @param <E>
 */
public class MyList<E extends Comparable<E>> {

    // khai báo private để Node chỉ dùng cho riêng class list
    private static class Node<E> {

        // Kiểu E là một object có thể truyền đối tượng
        private E info;
        private Node<E> next;

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
    
    Node<E> head, tail, sorted;

    public MyList() {
        head = tail = null;
    }

    void clear() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    // Add to head of lineked list
    public void addFirst(E x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    //add last
    public void addLast(E x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    // Print all info in linked list
    public void traverse() {
        Node p = head;
        while (p != null) {
            System.out.println(p.info);
            p = p.next;
        }
        System.out.println();
    }

    //search
    public E search(E x) {
        if (isEmpty()) {
            System.out.println("The list is empty.");
        }
        boolean check = false;
        Node<E> currentNode = head;
        while (currentNode != null) {
            // when Object exits in lined list
            if (currentNode.info.equals(x)) {
                check = true;
                break;
            }
            currentNode = currentNode.next;
        }
        // when Object not exits in linked list
        if (!check) {
            System.out.println("The given list does not have x object.");
            return null;
        }
        return currentNode.info;
    }

// delete Node have info = Object(pcode, ccode)
    public void delete(E x) {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        Node<E> currentNode = head;
        Node<E> pre_Node = new Node();

        //find the node previous of the the node want to delete
        while (!currentNode.info.equals(x) && currentNode.next != null) {
            pre_Node = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode.next == null) {
            System.out.println("The given list does not have x value.");
            return;
        }
        pre_Node.next = currentNode.next;
    }

    // sort linked list
    public void sort() {
        sorted = null;
        Node<E> currentNode = head;

        while (currentNode != null) {
            Node<E> next = currentNode.next;
            sortInsert(currentNode);
            currentNode = next;
        }
        head = sorted;
    }

    void sortInsert(Node<E> newNode) {
        // Specail case for head end
        if (sorted == null || sorted.info.compareTo(newNode.info) <= 0) { //>=
            newNode.next = sorted;
            sorted = newNode;
        } else {
            Node<E> currentNode = sorted;
            /* Locate the node before the point of insertion */
            while (currentNode.next != null && currentNode.next.info.compareTo(newNode.info) > 0) { //<
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }

    //insert after position k
    public void addBeforePositionK(int k, E c) {
        Node<E> p = new Node(c);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        // calculate position
        int count = 0;
        Node<E> currentNode = head;
        while (currentNode != null && count != k) {
            currentNode = currentNode.next;
            count++;
        }
        Node<E> preNode = currentNode.next;
        currentNode.next = p;
        p.next = preNode;
    }

    //delete before node
    public void deleteAfterNode(E x) {
        if (isEmpty()) {
            System.out.println("The list is empty.");
        }
        boolean check = false;
        Node<E> currentNode = head;
        Node<E> deletedNode = new Node();
        while (currentNode != null) {
            // when Object exits in lined list
            if (currentNode.info.equals(x)) {
                check = true;
                break;
            }
            currentNode = currentNode.next;
        }
        // when Object not exits in linked list
        if (!check) {
            System.out.println("The given list does not have x object.");
            return;
        }
        if (currentNode.next == null) {
            System.out.println("Tail of linked list is null.");
            return;
        }
        deletedNode = currentNode.next;
        currentNode.next = deletedNode.next;
        System.out.println("Delete sucessfull.");
    }

    //delete node first after node have position k
//    public void deleteNodeBeforeBcode(String xCode) {
//        Node p = search(xCode);
//        if (p == head) {//if p is head then donothing
//            return;
//        }
//        for (Node i = head; i != null; i = i.next) {
//            Node temp = i.next;
//            if(temp.info.getBcode().equalsIgnoreCase(xCode)){
//                dele(i);
//                break;
//            }
//        }
//    }
//    
//    //check bcode duplicate
//    public boolean checkBcode(String xCode){
//            for (Node i = head; i != null; i = i.next) {
//                if(i.info.getBcode().equalsIgnoreCase(xCode)){
//                    return false;
//                }
//            }
//            return true;
//    }
}
