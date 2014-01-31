package parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringTokenizer;

public class URLScanner {
    public static String DELIMETERS = "(),";

    private String baseURL;
    private long value;
    private URL url;
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private Token currentToken;

    public URLScanner(String baseURL, long value) {
        this.baseURL = baseURL;
        this.value = value;
        prepareNewURL(value);
    }

    public void prepareNewURL(long value) {
        try {
            url = new URL(baseURL + value);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            tokenizer = new StringTokenizer(reader.readLine(), DELIMETERS);
        } catch (IOException ex) { ex.printStackTrace(); }
    }

    public Token getCurrentToken() { return currentToken; }

    public Token nextToken() {
        String text = null;
        Token token = null;
        TokenType type;

        try {
            if (!tokenizer.hasMoreTokens() && (text = reader.readLine()) != null) {
                tokenizer = new StringTokenizer(text, DELIMETERS);
            }

            if (tokenizer.hasMoreTokens()) {
                text = tokenizer.nextToken();
                type = TokenType.TOKEN_TYPES.get(text.toLowerCase());
                token = new Token(text, type);
            }

            if (text != null && text.matches("-?\\d+(\\.\\d+)?")) {
                token = new Token(text, TokenType.NUMBER);
                token.setValue(Long.parseLong(text));
            }
        } catch (IOException ex) { ex.printStackTrace(); }

        currentToken = token;
        return token;
    }
}
