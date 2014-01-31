package graph;

import java.util.HashSet;
import java.util.Set;

public class GraphNode {
    private long value;
    private GraphNode parent;
    private int distance;
    private Set<GraphNode> adjacencyList;

    public GraphNode(long value, GraphNode parent) {
        this.value = value;
        adjacencyList = new HashSet<GraphNode>();

        if (parent != null) {
            parent.addEdge(this);
        } else {
            distance = 0;
        }
    }

    public long getValue() { return value; }
    public GraphNode getParent() { return parent; }
    public void setParent(GraphNode parent) { this.parent = parent; }

    public void addEdge(GraphNode parent) {
        adjacencyList.add(this);

        if (parent.distance + 1 < distance) {
            distance = parent.distance + 1;
            parent.setParent(this);
        }
    }
}
