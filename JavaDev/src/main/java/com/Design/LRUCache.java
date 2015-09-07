package com.Design;

import java.util.HashMap;

/**
 * Created by mwu on 7/13/15.
 */
public class LRUCache<K,V> {

    private final int maxItem;
    private HashMap<K,Node> hashMap = new HashMap<>();
    private Node<K,V> llRoot;
    private Node<K,V> llEnd;

    public LRUCache(int max){
        maxItem = max;
    }

    public Node<K,V>getNode(K key){
        Node<K,V> node = null;
        synchronized(hashMap) {
            if (hashMap.containsKey(key)) {
                node = hashMap.get(key);
                remove(node);
                setHead(node);
            }
        }
        return node;
    }

    public void setNode(K key,V val){
        Node<K,V> node;
        synchronized(hashMap) {
            if (hashMap.containsKey(key)) {
                node = hashMap.get(key);
                remove(node);
                setHead(node);
            } else {
                node = new Node<>(key, val);

                if (hashMap.size() >= maxItem) {
                    hashMap.remove(llEnd.key);
                    remove(node);

                }
                hashMap.put(key, node);
                setHead(node);
            }
        }
    }

    public void remove(Node<K,V> node){
        //pre-node-next
        if(node.pre != null){
            node.pre = node.next;
        }
        else {
            llRoot = node.next;
        }
        if(node.next != null){
            node.next.pre = node.pre;
        }
        else {
            llEnd = node.pre;
        }
    }

    public void setHead(Node<K,V> node){
        if(llRoot == null){
            llRoot = node;
        }
        else {
            node.next = llRoot;
            llRoot.pre = node;
            llRoot = node;
        }
        if(llEnd == null){
            llEnd = llRoot;
        }
    }
}
