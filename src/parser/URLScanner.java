package parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringTokenizer;

public class URLScanner {
    public static String DELIMETERS = "(),";

    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public URLScanner(String url) {
        try {
            reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            tokenizer = new StringTokenizer(reader.readLine(), DELIMETERS);
        } catch (IOException ex) { ex.printStackTrace(); }
    }

    public Token nextToken() {
        String text = null;
        Token token = null;

        try {
            if (!tokenizer.hasMoreTokens() && (text = reader.readLine()) != null) {
                tokenizer = new StringTokenizer(text, DELIMETERS);
            }

            if (tokenizer.hasMoreTokens()) {
                text = tokenizer.nextToken();
                TokenType type = TokenType.TOKEN_TYPES.get(text.toLowerCase());
                token = new Token(type);
            }

            if (text != null && text.matches("-?\\d+(\\.\\d+)?")) {
                token = new Token(TokenType.NUMBER);
                token.setValue(Long.parseLong(text));
            }
        } catch (IOException ex) { ex.printStackTrace(); }

        return token;
    }
}
