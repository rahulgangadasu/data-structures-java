package dsa;

public class GraphsDemo {
    public static void main(String[] args) {
        var graph = new Graphs();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");
        graph.print();
        graph.traverseDepthFirst("A");
        System.out.println();
        graph.traverseDepthFirstIterative("A");
        System.out.println();
        graph.traverseBreadthFirst("A");
        System.out.println();
        var graph1 = new Graphs();
        graph1.addNode("X");
        graph1.addNode("A");
        graph1.addNode("B");
        graph1.addNode("P");
        graph1.addEdge("X", "A");
        graph1.addEdge("X", "B");
        graph1.addEdge("A", "P");
        graph1.addEdge("B", "P");
        var list = graph1.topologicalSort();
        System.out.println(list);
    }
}
