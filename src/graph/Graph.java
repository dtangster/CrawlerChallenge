package graph;

import java.util.*;

public class Graph {
    private Map<Long, GraphNode> nodes;
    private long goal;
    private int cycleCount;
    boolean graphChanged;

    public Graph(Long startPoint) {
        nodes = new HashMap<Long, GraphNode>();
        nodes.put(startPoint, new GraphNode(startPoint));
        goal = -1; // -1 represents not found
        cycleCount = 0;
        graphChanged = true;
    }

    public Deque<Long> getShortestPath() {
        if (goal == -1) {
            return null; // Return if goal has not been found yet
        }

        Deque<Long> shortestPath = new ArrayDeque<Long>();
        GraphNode node = nodes.get(goal);

        while (node != null) {
            shortestPath.add(node.getValue());
            node = node.getParent();
        }

        return shortestPath;
    }

    public int getCycleCount() {
        if (!graphChanged) {
            return cycleCount;
        }

        Set<GraphNode> visited = new HashSet<GraphNode>();
        Set<GraphNode> finished = new HashSet<GraphNode>();

        for (GraphNode u : nodes.values()) {
            if (visited.add(u)) {
                depthFirstSearch(u, visited, finished);
            }
        }

        graphChanged = false;
        return cycleCount;
    }

    public void depthFirstSearch(GraphNode u, Set<GraphNode> visited, Set<GraphNode> finished) {
        for (GraphNode v : u.getAdjacencyList()) {
            if (visited.add(v)) {
                depthFirstSearch(v, visited, finished);
            }
        }

        finished.add(u);
    }

    public void addNode(GraphNode node) {
        nodes.put(node.getValue(), node);
        graphChanged = true;
    }

    public void addEdge(GraphNode parent, GraphNode child) {
        parent.addEdge(child);
        graphChanged = true;
    }

    public GraphNode getNode(long value) { return nodes.get(value); }
    public long getGoal() { return goal; }
    public void setGoal(long goal) { this.goal = goal; }
    public long getNodeCount() { return nodes.size(); }
}
