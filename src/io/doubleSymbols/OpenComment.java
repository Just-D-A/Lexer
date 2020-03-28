package io.doubleSymbols;

import domain.Token;
import globals.Globals;

public class OpenComment extends DoubleSymbols {
    @Override
    public Token execute(String val, int line, int position) throws Exception {
        return new Token(Globals.COMMENT_OPEN_KEY, val, line, position);
        //token.writeToken();
    }
}
