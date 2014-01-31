package evaluator;

public class GoalNode extends SyntaxNode {
    public static int PARAMETER_COUNT = 0;

    public GoalNode() {}
    public GoalNode(long value) { super(value); }
    public long accept(NodeVisitor visitor) { return visitor.visit(this); }
    public int getParameterCount() { return PARAMETER_COUNT; }
}
