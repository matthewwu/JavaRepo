package com.Design;

/**
 * Created by mwu on 7/13/15.
 */
public class Node<K,V> {

    public K key;
    public V value;
    Node next;
    Node pre;

    public Node(K key,V val){
        this.key = key;
        this.value = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

}
