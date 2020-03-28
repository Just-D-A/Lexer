package io.specialSymbols;

import domain.Token;
import globals.Globals;

public class Semicolon extends SpecialSymbols {
    @Override
    public Token execute(String val, int line, int position) throws Exception {
        return new Token(Globals.SEMICOLON_KEY, val, line, position);
        //token.writeToken();
    }
}
