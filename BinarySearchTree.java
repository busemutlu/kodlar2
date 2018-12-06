package com.example.dilay.myapplication;

public class BinarySearchTree {

    Node root;
    public String preOrderAns="",inOrderAns="",postOrderAns="";

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // This method mainly calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    void inorder()  {
        inorderRec(root);
    }

    void preorder()  {
        preorderRec(root);
    }

    void postorder()  {
        postorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {


            inorderRec(root.left);
            inOrderAns=inOrderAns+root.key+" ";
           // System.out.println(root.key);
            inorderRec(root.right);
        }
    }
    void preorderRec(Node root) {
        if (root != null) {
            //System.out.println(root.key);
            preOrderAns=preOrderAns+root.key+" ";
            //p=p+String.valueOf(root.key);
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }void postorderRec(Node root) {
        if (root != null) {

            postorderRec(root.left);
            postorderRec(root.right);
            postOrderAns=postOrderAns+root.key+" ";
           // System.out.println(root.key);
        }
    }


}
