import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>{

    private Node root;

    ///region Constructors

    public BinarySearchTree(){
        this.root = null;
    }

    public BinarySearchTree(T data){
        this.root = new Node(data);
    }

    ///endregion

    ///region Interface Methods

    @Override
    public boolean isEmpty() {
        if(root == null){
            return true;
        }
        return false;
    }

    @Override
    public void insert(T data) {
        root = BSTInsert(root,data);
    }

    @Override
    public void delete(T target) {
        root = BSTDelete(root,target);
    }

    @Override
    public boolean contains(T target) {
        return BSTContains(root,target);
    }

    ///endregion

    private T getMin(Node node){
        if(node == null){
            return null;
        }
        if(node.left == null) {
            return node.data;
        }

        return getMin(node.left);
    }

    private T getMax(Node node){
        if(node == null){
            return null;
        }
        if(node.right == null) {
            return node.data;
        }

        return getMax(node.right);
    }

    private Node BSTInsert(Node root, T data){
        if(root == null){
            return new Node(data);
        }

        if(data.compareTo(root.data) < 0){
            root.left = BSTInsert(root.left, data);
        }

        if(data.compareTo(root.data) > 0){
            root.right = BSTInsert(root.right, data);
        }

        return root;
    }

    private Node BSTDelete(Node root, T target){
        if(root == null){
            return null;
        }

        if(target == root.data){
            if(root.left == null && root.right == null){
                return null;
            }

            if(root.left == null){
                return root.right;
            }

            if(root.right == null){
                return root.left;
            }

            //set the data of root to either the predecessor or the successor
            root.data = getMax(root);
            //set the left child of root to the result of calling delete on it,
            //  passing the data of root
            return BSTDelete(root.left, root.data);
        }

        //if greater than
        if(target.compareTo(root.data) > 0){
            //return the outcome of calling delete on the right child of root
            return BSTDelete(root.right, target);
        }

        //if less than
        if(target.compareTo(root.data) < 0){
            //return the outcome of calling delete on the left child of root
            return BSTDelete(root.left, target);
        }

        return null;
    }

    private boolean BSTContains(Node root, T target){
        if(root == null){
            System.out.println("Root is null.");
            return false;
        }

        if(root.data == target){
            return true;
        }

        if(target.compareTo(root.data) < 0){
            return BSTContains(root.left, target);
        }

        if(target.compareTo(root.data) > 0){
            return BSTContains(root.right, target);
        }

        return false;
    }

    private class Node{
        Node left;
        Node right;
        T data;

        Node(T data){
            this.data = data;
            left = right = null;
        }
    }
}
