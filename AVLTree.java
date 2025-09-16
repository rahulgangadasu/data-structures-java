package dsa;

public class AVLTree {

    private class AVLNode{
        private int value;
        private int height;
        private AVLNode leftChild;
        private AVLNode rightChild;
        public AVLNode(int value){
            this.value = value;
        }
    }
    private AVLNode root;

    public void insert(int value){
        root = insert(root, value);
    }
    private AVLNode insert(AVLNode root, int value){
        if(root == null) return new AVLNode(value);
        if(value < root.value){
            root.leftChild = insert(root.leftChild, value);
        }    
        else if (value > root.value){
            root.rightChild = insert(root.rightChild, value);
        }
        else{
        }
       setHeight(root);
     return balance(root);
    }

    private AVLNode balance(AVLNode root){
        if (isLeftHeavy(root)) { 
            if (balanceFactor(root.leftChild) < 0)
                root.leftChild = leftRotate(root.leftChild);
            return rightRotate(root);
        }
        else if (isRightheavy(root)) {
            if (balanceFactor(root.rightChild) > 0)
                root.rightChild = rightRotate(root.rightChild);
            return leftRotate(root);
        }
        return root;
    }

    private AVLNode leftRotate(AVLNode root){
        AVLNode newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private AVLNode rightRotate(AVLNode root){
        AVLNode newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private boolean isLeftHeavy(AVLNode node){
        return balanceFactor(node) > 1;
    }

    private boolean isRightheavy(AVLNode node){
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node){
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }
    private int height(AVLNode root){
        return (root == null) ? -1 : root.height;
    }

    private void setHeight(AVLNode node){
        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
    }
}
