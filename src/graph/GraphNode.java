package graph;

import java.util.HashSet;
import java.util.Set;

public class GraphNode {
    private long value;
    private GraphNode parent;
    private Set<GraphNode> adjacencyList;

    public GraphNode(long value) {
        this.value = value;
        adjacencyList = new HashSet<GraphNode>();
    }

    public long getValue() { return value; }
    public GraphNode getParent() { return parent; }
    public void setParent(GraphNode parent) { this.parent = parent; }
    public boolean addEdge(GraphNode node) { return adjacencyList.add(node); }
}
