package parser;

import evaluator.*;

/**
 * This class tokenizes the operations and integers
 */
public class ExpressionParser {
    private URLScanner scanner;

    public ExpressionParser(URLScanner scanner) { this.scanner = scanner; }

    public Token nextToken() { return scanner.nextToken(); }

    public SyntaxNode parse() {
        Token token = nextToken();
        SyntaxNode root = null;

        if (token != null) {
            switch (token.getType()) {
                case ABSOLUTE_VALUE:
                    root = new AbsoluteValueNode();
                    root.addChild(parseExpression());
                    break;
                case DEADEND:
                    root = new DeadEndNode();
                    break;
                case GOAL:
                    root = new GoalNode();
            }
        }

        return root;
    }

    private SyntaxNode parseExpression() {
        Token token = nextToken();
        SyntaxNode node = null;

        switch (token.getType()) {
            case ABSOLUTE_VALUE:
                node = new AbsoluteValueNode();
                break;
            case ADD:
                node = new AddNode();
                break;
            case MULTIPLY:
                node = new MultiplyNode();
                break;
            case SUBTRACT:
                node = new SubtractNode();
                break;
            case NUMBER:
                node = new NumberNode(token.getValue());
        }

        parseParameters(node);
        return node;
    }

    private void parseParameters(SyntaxNode root) {
        while (root.getChildren().size() < root.getParameterCount()) {
            root.addChild(parseExpression());
        }
    }
}
