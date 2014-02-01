package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Map;

public class Graph {
    private Map<Long, GraphNode> nodes;
    private long goal;
    private int cycleCount;
    private int time;
    boolean edgeAdded;

    public Graph(Long startPoint) {
        nodes = new LinkedHashMap<Long, GraphNode>();
        nodes.put(startPoint, new GraphNode(startPoint));
        goal = -1; // -1 represents not found
        edgeAdded = true; // If true, we need to recalculate cycleCount
    }

    public Deque<Long> getShortestPath() {
        if (goal == -1) {
            return null; // Return if goal has not been found yet
        }

        Deque<Long> shortestPath = new ArrayDeque<Long>();
        GraphNode node = nodes.get(goal);

        while (node != null) {
            shortestPath.push(node.getValue());
            node = node.getParent();
        }

        return shortestPath;
    }

    public int getCycleCount() {
        if (!edgeAdded) {
            return cycleCount;
        }

        time = 0;
        cycleCount = 0;

        for (GraphNode u : nodes.values()) {
            if (u.getVisitTime() == 0) {
                depthFirstSearch(u);
            }
        }

        edgeAdded = false;
        return cycleCount;
    }

    public void depthFirstSearch(GraphNode u) {
        u.setVisitTime(++time);

        for (GraphNode v : u.getAdjacencyList()) {
            if (v.getVisitTime() == 0) {
                depthFirstSearch(v);
            }
            else if (v.getCompleteTime() == 0 && u.getVisitTime() > v.getVisitTime()) {
                cycleCount++;
            }
        }

        u.setCompleteTime(++time);
    }

    public void addEdge(GraphNode parent, GraphNode child) {
        parent.addEdge(child);
        edgeAdded = true;
    }

    public GraphNode getNode(long value) { return nodes.get(value); }
    public void addNode(GraphNode node) { nodes.put(node.getValue(), node); }
    public long getGoal() { return goal; }
    public void setGoal(long goal) { this.goal = goal; }
    public long getNodeCount() { return nodes.size(); }
}
