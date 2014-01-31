package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Graph {
    private Map<Long, GraphNode> nodes;
    private long startPoint;
    private long goal;
    private long cycleCount;

    public Graph(Long startPoint) {
        nodes = new HashMap<Long, GraphNode>();
        this.startPoint = startPoint;
        nodes.put(startPoint, new GraphNode(startPoint));
        goal = -1; // -1 represents not found
        cycleCount = 0;
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

    public boolean addNode(long value) {
        if (nodes.containsKey(value)) {
            return false;
        }

        nodes.put(value, new GraphNode(value));
        return true;
    }

    public void addAdjacencyListNode(long value, long parentValue) {
        GraphNode parentNode = nodes.get(parentValue);
        GraphNode treeNode = new GraphNode(value);

        parentNode.addEdge(treeNode);
        treeNode.setParent(parentNode);
        nodes.put(value, treeNode);
    }

    public long getGoal() { return goal; }
    public void setGoal(long goal) { this.goal = goal; }
    public long getNodeCount() { return nodes.size(); }
    public long getCycleCount() { return cycleCount; }
    public void incrementCycleCount() { cycleCount++; }
}
