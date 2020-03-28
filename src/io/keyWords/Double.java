package io.keyWords;

import domain.Token;
import globals.Globals;

public class Double extends KeyWord {
    @Override
    public Token execute(String val, int line, int position) throws Exception {
        return new Token(Globals.DOUBLE_KEY, "double", line, position);
        //token.writeToken();

    }
}
