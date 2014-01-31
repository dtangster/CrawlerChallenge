package evaluator;

public class AbsoluteValueNode extends SyntaxNode {
    public static int PARAMETER_COUNT = 1;

    public AbsoluteValueNode() {}
    public AbsoluteValueNode(long value) { super(value); }
    public long accept(NodeVisitor visitor) { return visitor.visit(this); }
    public int getParameterCount() { return PARAMETER_COUNT; }
}
