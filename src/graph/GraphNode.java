package graph;

import java.util.HashSet;
import java.util.Set;

public class GraphNode {
    private long value;
    private GraphNode parent;
    private int minDepth; // Depth from the start page
    private int visitTime;
    private int completeTime;
    private Set<GraphNode> adjacencyList;

    public GraphNode(long value) {
        this.value = value;
        adjacencyList = new HashSet<GraphNode>();
    }

    public void addEdge(GraphNode child) { adjacencyList.add(child); }
    public Set<GraphNode> getAdjacencyList() { return adjacencyList; }
    public long getValue() { return value; }
    public GraphNode getParent() { return parent; }
    public void setParent(GraphNode parent) { this.parent = parent; }
    public int getMinDepth() { return minDepth; }
    public void setMinDepth(int minDepth) { this.minDepth = minDepth; }
    public int getVisitTime() { return visitTime; }
    public void setVisitTime(int visitTime) { this.visitTime = visitTime; }
    public int getCompleteTime() { return completeTime; }
    public void setCompleteTime(int completeTime) { this.completeTime = completeTime; }
}
