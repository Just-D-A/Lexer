package main.org.volgatech.lexer.io.keyWords;

import main.org.volgatech.lexer.Globals.Globals;
import main.org.volgatech.lexer.domain.Token;

public class KeyWord {
    public Token execute(String val, int line, int position) throws Exception {
        return new Token(Globals.KEY_WORD_KEY, val, line, position);
    }
}