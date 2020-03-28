package io.specialSymbols;

import domain.Token;
import globals.Globals;

public class Space extends SpecialSymbols {
    @Override
    public Token execute(String val, int line, int position) throws Exception {
        return new Token(Globals.SPACE_KEY, val, line, position);
    }
}
