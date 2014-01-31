package parser;

public class Token {
    private TokenType type;
    private long value;

    public Token(TokenType type) { this.type = type; }

    public TokenType getType()  { return type; }
    public long getValue() { return value; }
    public void setValue(long value) { this.value = value; }
}