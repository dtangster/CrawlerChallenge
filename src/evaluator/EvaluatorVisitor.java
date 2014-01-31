package evaluator;

import java.util.List;

/**
 * This class uses the Visitor pattern with SyntaxNode to evaluate expressions
 */
public class EvaluatorVisitor extends NodeVisitor {
    public long visit(AbsoluteValueNode node) {
        List<SyntaxNode> children = node.getChildren();
        long x = children.get(0).accept(this);

        return x >= 0 ? x : -x;
    }

    public long visit(AddNode node) {
        List<SyntaxNode> children = node.getChildren();
        long x = children.get(0).accept(this);
        long y = children.get(1).accept(this);

        return x + y;
    }

    public long visit(MultiplyNode node) {
        List<SyntaxNode> children = node.getChildren();
        long x = children.get(0).accept(this);
        long y = children.get(1).accept(this);

        return x * y;
    }

    public long visit(SubtractNode node) {
        List<SyntaxNode> children = node.getChildren();
        long x = children.get(0).accept(this);
        long y = children.get(1).accept(this);

        return x - y;
    }

    public long visit(NumberNode node) { return node.getValue(); }
    public long visit(DeadEndNode node) { return -2; }
    public long visit(GoalNode node) { return -1; }
}
