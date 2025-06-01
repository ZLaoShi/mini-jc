package lexer;

public class Lexer {

    public Lexer(char[] buf) {
    }

    public Token nextToken() {
        return  new Token(TokenKind.EOF, "");
    }
}
