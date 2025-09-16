package dsa;

import java.util.ArrayList;

public class Trees {

    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value){
            this.value = value;
        }
    }
    private Node root;

    public void insert(int value){
        Node newNode = new Node(value);
        if(root == null){ root = newNode; return;}
        Node currentNode = root;
        while (true) {
            if (value < currentNode.value) {
                if (currentNode.leftChild == null) {
                    currentNode.leftChild = newNode;
                break;
                }
                currentNode = currentNode.leftChild;
            }
            else{
                if (currentNode.rightChild == null) {
                    currentNode.rightChild = newNode;
                break;
                }  
                currentNode = currentNode.rightChild;
            }
        }
    }
    public boolean find(int key){
        Node currentNode = root;
        while (currentNode != null) {
            if (key < currentNode.value) {
                currentNode = currentNode.leftChild;
            }
            else if (key > currentNode.value){
                currentNode = currentNode.rightChild;
            }
            else
                return true;
        }
        return false;
    }
    public void traversals(){
        System.out.print("Pre-Order Traversal : ");
        traversePreOrder(root);
        System.out.println();
        System.out.print("In-Order Traversal  : ");
        traverseInOrder(root);
        System.out.println();
        System.out.print("Post-Order Traversal: ");
        traversePostOrder(root);
        System.out.println();
        System.out.println("Height of Tree : " + height(root));
        System.out.println("Minimum value in Tree : "+ min(root));
        System.out.println("Is a Binary Search Tree? : " + 
                            isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private void traversePreOrder(Node root){
        if(root == null)
            return;
        System.out.print(root.value + " ");
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    private void traverseInOrder(Node root){
        if (root == null)
            return;
        traverseInOrder(root.leftChild);
        System.out.print(root.value + " ");
        traverseInOrder(root.rightChild);
    }
    private void traversePostOrder(Node root){
        if (root == null)
            return;
        traverseInOrder(root.leftChild);
        traverseInOrder(root.rightChild);
        System.out.print(root.value + " ");
    }

    private int height(Node root){
        if (root == null) return -1;
        if (isLeaf(root))
            return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private boolean isLeaf(Node root){
        return root.leftChild == null && root.rightChild == null;
    }

    private int min(Node root){
        if (isLeaf(root)) return root.value;
        var left  = min(root.leftChild);
        var right = min(root.rightChild);
        return Math.min(Math.min(left, right), root.value);
    }

    public boolean equals(Trees tree){
        if (tree == null) return false;
       return equals(root, tree.root);
    }
    private boolean equals(Node firstTreeNode, Node secondTreeNode) {
        if(firstTreeNode == null && secondTreeNode == null)
            return true;
        if(firstTreeNode != null && secondTreeNode != null)
            return firstTreeNode.value == secondTreeNode.value 
                && equals(firstTreeNode.leftChild, secondTreeNode.leftChild)
                && equals(firstTreeNode.rightChild, secondTreeNode.rightChild);
        return false;
    }
    private boolean isBinarySearchTree(Node root, int min, int max){
        if(root == null) return true;
        if(root.value < min || root.value > max) return false;
        return isBinarySearchTree(root.leftChild, min, root.value - 1)
            && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance){
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list ;
    }

    private void  getNodesAtDistance(Node root, int distance, ArrayList<Integer> list){
        if(root == null) return;
        if(distance == 0) {  
            list.add(root.value);
            return;
        }
        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }

    public void traverseLevelOrder(){
        for(int i = 0; i <= height(root); i++){
            for (var value : getNodesAtDistance(i)) {
                System.out.print(value + " ");
            }
        }
    }
}
