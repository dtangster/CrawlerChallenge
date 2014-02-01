package graph;

import evaluator.EvaluatorVisitor;
import evaluator.NodeVisitor;
import evaluator.SyntaxNode;
import parser.ExpressionParser;
import parser.URLScanner;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * This constructs the Graph while performing BFS on the expressions that have
 * been evaluated by the Visitor pattern
 */
public class GraphBuilder {
    private String baseURL;
    private long startExpression;
    private Graph graph;
    private NodeVisitor visitor;
    private Deque<Long> queue;
    private boolean graphBuilt;

    public GraphBuilder(String baseURL, long startExpression) {
        this.baseURL = baseURL;
        this.startExpression = startExpression;
        graph = new Graph(startExpression);
        visitor = new EvaluatorVisitor();
        queue = new ArrayDeque<Long>();
        graphBuilt = false;
    }

    public Graph buildGraph() {
        if (!graphBuilt) {
            buildGraph(startExpression); // Build initial queue

            while (!queue.isEmpty()) {
                buildGraph(queue.removeFirst());
            }

            graphBuilt = true;
        }

        return graph;
    }

    private void buildGraph(long startPoint) {
        URLScanner reader = new URLScanner(baseURL + startPoint);
        ExpressionParser parser = new ExpressionParser(reader);
        SyntaxNode root = parser.parse();

        while (root != null) {
            long newStartPoint = root.accept(visitor);
            GraphNode parent = graph.getNode(startPoint);
            int newDistance = parent.getMinDepth() + 1;
            System.out.println(newStartPoint);

            if (newStartPoint == -1) {
                graph.setGoal(startPoint);
            }
            else if (newStartPoint >= 0) {
                GraphNode child = graph.getNode(newStartPoint);

                if (child == null) {
                    child = new GraphNode(newStartPoint);
                    child.setMinDepth(parent.getMinDepth() + 1);
                    child.setParent(parent);
                    graph.addNode(child);
                    queue.add(child.getValue());
                }
                else if (newDistance < child.getMinDepth()) {
                    child.setMinDepth(newDistance);
                    child.setParent(parent);
                }

                graph.addEdge(parent, child);
            }

            root = parser.parse();
        }
    }
}
