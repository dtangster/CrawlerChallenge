package parser;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a convenience class to simplify the identification of tokens
 */
public enum TokenType {
    ABSOLUTE_VALUE("abs"), ADD, MULTIPLY, SUBTRACT, DEADEND, GOAL, NUMBER;

    private static final int FIRST_TOKEN_INDEX = ABSOLUTE_VALUE.ordinal();
    private static final int LAST_TOKEN_INDEX = NUMBER.ordinal();

    public static Map<String, TokenType> TOKEN_TYPES = new HashMap<String, TokenType>();

    private String text;

    TokenType() { text = toString().toLowerCase(); }
    TokenType(String text) { this.text = text; }
    public String getText() { return text; }

    static {
        TokenType values[] = values();

        for (int i = FIRST_TOKEN_INDEX; i <= LAST_TOKEN_INDEX; ++i) {
            TOKEN_TYPES.put(values[i].getText().toLowerCase(), values[i]);
        }
    }
}