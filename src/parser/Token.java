package parser;

public class Token {
    private TokenType type;
    private String text;
    private long value;

    public Token(String text, TokenType type) {
        this.text = text;
        this.type = type;
    }

    public TokenType getType()  { return type; }
    public String getText()  { return text; }
    public long getValue() { return value; }
    public void setValue(long value) { this.value = value; }
    public String toString() { return text; }
}