package evaluator;

/**
 * Created by Tang on 1/28/14.
 */
public class SubtractNode extends SyntaxNode {
    public static int PARAMETER_COUNT = 2;

    public SubtractNode() {}
    public SubtractNode(long value) { super(value); }
    public long accept(NodeVisitor visitor) { return visitor.visit(this); }
    public int getParameterCount() { return PARAMETER_COUNT; }
}
