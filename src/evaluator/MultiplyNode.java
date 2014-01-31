package evaluator;

public class MultiplyNode extends SyntaxNode {
    public static int PARAMETER_COUNT = 2;

    public MultiplyNode() {}
    public MultiplyNode(Long value) { super(value); }
    public long accept(NodeVisitor visitor) { return visitor.visit(this); }
    public int getParameterCount() { return PARAMETER_COUNT; }
}
