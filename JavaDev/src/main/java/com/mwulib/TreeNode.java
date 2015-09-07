package com.mwulib;

import java.security.cert.TrustAnchor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by mwu on 6/23/15.
 */
public class TreeNode<T extends Comparable> {

    public TreeNode<T> left;
    public TreeNode<T> right;
    public T data;

    public void BFS(TreeNode<T> root){

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode<T> node = queue.poll();
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
            visitNode(node.data);
        }
    }

    public void DFS(TreeNode<T> root){

        Stack<TreeNode<T>> stack = new Stack<>();

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode<T> node = stack.pop();
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
            visitNode(node.data);
        }

    }

    private void visitNode(T nodeData){

    }

}
