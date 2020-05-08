package main.org.volgatech.lexer.io.specialSymbols;

import main.org.volgatech.lexer.Globals.Globals;
import main.org.volgatech.lexer.domain.Token;

public class Semicolon extends SpecialSymbols {
    @Override
    public Token execute(String val, int line, int position) throws Exception {
        return new Token(Globals.SEMICOLON_KEY, val, line, position);
    }
}
