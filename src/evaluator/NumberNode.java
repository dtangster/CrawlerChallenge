package evaluator;

public class NumberNode extends SyntaxNode {
    public static int PARAMETER_COUNT = 0;

    public NumberNode() {}
    public NumberNode(long value) { super(value); }
    public long accept(NodeVisitor visitor) { return visitor.visit(this); }
    public int getParameterCount() { return PARAMETER_COUNT; }
}
