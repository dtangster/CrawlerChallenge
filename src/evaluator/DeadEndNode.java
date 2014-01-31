package evaluator;

public class DeadEndNode extends SyntaxNode {
    public static int PARAMETER_COUNT = 0;

    public DeadEndNode() {}
    public DeadEndNode(long value) { super(value); }
    public long accept(NodeVisitor visitor) { return visitor.visit(this); }
    public int getParameterCount() { return PARAMETER_COUNT; }
}
