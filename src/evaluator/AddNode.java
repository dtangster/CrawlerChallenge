package evaluator;

public class AddNode extends SyntaxNode {
    public static int PARAMETER_COUNT = 2;

    public AddNode() {}
    public AddNode(long value) { super(value); }
    public long accept(NodeVisitor visitor) { return visitor.visit(this); }
    public int getParameterCount() { return PARAMETER_COUNT; }
}
