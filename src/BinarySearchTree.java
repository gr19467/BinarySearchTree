public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>{

    private Node root;

    private BinarySearchTree(){
        this.root = null;
    }

    private BinarySearchTree(T data){
        this.root = new Node(data);
    }

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

    private T getMin(Node node){
        if(node == null) {
            return node.data;
        }

        return getMin(node.left);
    }

    private T getMax(Node node){
        if(node == null) {
            return node.data;
        }

        return getMax(node.right);
    }

    private Node BSTInsert(Node current, T data){
        if(current == null){
            return new Node(data);
        }

        if(current.data == data){
            return current;
        }

        if(data.compareTo(current.data) < 0){
            return BSTInsert(current.left, data);
        }

        if(data.compareTo(current.data) > 0){
            return BSTInsert(current.right, data);
        }

        return null;
    }

    private Node BSTDelete(Node current, T target){
        if(current == null){
            return null;
        }

        if(target == current.data){
            if(current.left == null && current.right == null){
                return null;
            }

            if(current.left == null){
                return current.right;
            }

            if(current.right == null){
                return current.left;
            }

            //set the data of current to either the predecessor or the successor
        }
    }

    private boolean BSTContains(Node current, T target){
        if(current == null){
            return false;
        }

        if(current == target){
            return true;
        }

        if(target.compareTo(current.data) < 0){
            return BSTContains(current.left, target);
        }

        if(target.compareTo(current.data) > 0){
            return BSTContains(current.right, target);
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
