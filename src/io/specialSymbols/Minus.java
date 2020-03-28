package io.specialSymbols;

import domain.Token;
import globals.Globals;

public class Minus extends SpecialSymbols {
    @Override
    public Token execute(String val, int line, int position) throws Exception {
        return new Token(Globals.ARITHMETIC_OPERATION_KEY, val, line, position);
        //token.writeToken();
    }
}
