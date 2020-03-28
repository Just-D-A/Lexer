package io.keyWords;

import domain.Token;
import globals.Globals;

public class Int extends KeyWord{
    @Override
    public Token execute(String val, int line, int position) throws Exception {
        return new Token(Globals.INTEGER_KEY, val, line, position);
        //token.writeToken();
    }
}
