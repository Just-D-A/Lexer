package io.identifiers;

import domain.Token;
import globals.Globals;

public class Identifiers {

    public Token checkIdentifier(String name, int line, int position) throws Exception {
        char[] charName = name.toCharArray();
        char ch;
        for (int i = 1; i < charName.length; i++) {
            ch = charName[i];
            if (!((ch >= 'a') && (ch <= 'z') || (ch >= 'A') && (ch <= 'Z') || (ch >= '0') && (ch <= '9'))) {
                return  null;
            }
        }
        return  new Token(Globals.IDENTIFIER_KEY, name, line, position);
        /*token.writeToken();
        return true;*/
    }
}
