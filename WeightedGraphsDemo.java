package dsa;

public class WeightedGraphsDemo {
    public static void main(String[] args) {
        var ugraph = new WeightedGraphs();
        ugraph.addNode("A");
        ugraph.addNode("B");
        ugraph.addNode("C");
        ugraph.addNode("D");
        ugraph.addEdge("A", "B", 3);
        ugraph.addEdge("B", "D", 4);
        ugraph.addEdge("C", "D", 5);
        ugraph.addEdge("A", "C", 1);
        ugraph.addEdge("B", "C", 2);

        ugraph.print();
        var path = ugraph.dijkistrasShortestPath("A", "C");
        System.out.println(path);
        System.out.println(ugraph.hasCycle());
        var tree = ugraph.getMinimumSpanningTree();
        tree.print();
    }
}
