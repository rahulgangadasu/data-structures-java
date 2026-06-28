package dsa;

public class TreesMain {
    public static void main(String[] args) {
        Trees tree = new Trees();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        tree.traversals();
        var list = tree.getNodesAtDistance(2);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();
        tree.traverseLevelOrder();
    }
}
