package io.keyWords;

import domain.Token;
import globals.Globals;

public class Write extends KeyWord {
    public Write() {

    }
    @Override
    public Token execute(String val, int line, int position) throws Exception {
        return new Token(Globals.KEY_WORD_KEY, val, line, position);
        //token.writeToken();
      //  System.out.println("write - command");
    }
}
