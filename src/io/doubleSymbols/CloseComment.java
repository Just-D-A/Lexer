package io.doubleSymbols;

import domain.Token;
import globals.Globals;

public class CloseComment extends DoubleSymbols {
    @Override
    public Token execute(String val, int line, int position) throws Exception {
        return new Token(Globals.COMMENT_CLOSE_KEY, val, line, position);
    }
}
