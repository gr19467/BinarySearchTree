public class Main {


    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(5);
        tree.insert(1);
        tree.insert(10);

        System.out.println(tree.contains(5));
        System.out.println(tree.contains(9));
        System.out.println(tree.contains(1));
        System.out.println(tree.contains(10));
    }
}
