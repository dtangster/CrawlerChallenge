package evaluator;

/**
 * This class is an adapter for the visitor pattern that has implementations to
 * visit all SyntaxNode types
 */
public abstract class NodeVisitor {
    public long visit(SyntaxNode node) { return node.childrenAccept(this); }
    public long visit(AbsoluteValueNode node) { return node.childrenAccept(this); }
    public long visit(AddNode node) { return node.childrenAccept(this); }
    public long visit(MultiplyNode node) { return node.childrenAccept(this); }
    public long visit(SubtractNode node) { return node.childrenAccept(this); }
    public long visit(NumberNode node) { return node.childrenAccept(this); }
    public long visit(DeadEndNode node) { return node.childrenAccept(this); }
    public long visit(GoalNode node) { return node.childrenAccept(this); }
}
