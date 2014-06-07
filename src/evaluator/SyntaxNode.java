package evaluator;

import java.util.ArrayList;
import java.util.List;

/**
 * This class uses the Visitor pattern with EvaluatorVisitor to evaluate expressions
 */
public abstract class SyntaxNode {
    private long value;
    private ArrayList<SyntaxNode> children;

    public SyntaxNode(long value) {
        this.value = value;
        children = new ArrayList<SyntaxNode>();
    }

    public SyntaxNode() { children = new ArrayList<SyntaxNode>(); }
    public long getValue() { return value; }
    public long accept(NodeVisitor visitor) { return visitor.visit(this); }
    public void addChild(SyntaxNode child) { children.add(child); }
    public List<SyntaxNode> getChildren() { return children; }

    public long childrenAccept(NodeVisitor visitor) {
        long total = 0;

        for (SyntaxNode node : children) {
            total += node.accept(visitor);
        }

        return total;
    }

    public abstract int getParameterCount();
}
