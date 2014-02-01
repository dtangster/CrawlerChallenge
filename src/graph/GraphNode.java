package graph;

import java.util.HashSet;
import java.util.Set;

public class GraphNode {
    private long value;
    private GraphNode parent;
    private int distance;
    private Set<GraphNode> adjacencyList;

    public GraphNode(long value) {
        this.value = value;
        adjacencyList = new HashSet<GraphNode>();
        distance = 0;
    }

    public long getValue() { return value; }
    public GraphNode getParent() { return parent; }
    public void setParent(GraphNode parent) { this.parent = parent; }
    public int getDistance() { return distance; }
    public void setDistance(int distance) { this.distance = distance; }
    public void addEdge(GraphNode child) { adjacencyList.add(child); }
    public Set<GraphNode> getAdjacencyList() { return adjacencyList; }
}
