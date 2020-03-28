package domain.tokenType;


import globals.Globals;

import java.util.HashMap;

public class TokenType {

    private HashMap<Integer, String> types = new HashMap<>();


    public TokenType() {
        types.put(Globals.ERROR_KEY,  "Error");
        types.put(Globals.ARITHMETIC_OPERATION_KEY,  "Arithmetic Operation");
        types.put(Globals.IDENTIFIER_KEY,  "Identifier");
        types.put(Globals.KEY_WORD_KEY,  "KeyWord");
        types.put(Globals.COMPARISON_OPERATION_KEY,  "Comparison Operation");
        types.put(Globals.INTEGER_KEY, "Integer");
        types.put(Globals.DOUBLE_KEY, "Double");;
        types.put(Globals.BINARY_KEY, "Binary");
        types.put(Globals.SEMICOLON_KEY, "Separator");
        types.put(Globals.STRING_VAL_KEY, "String Value");
        types.put(Globals.COMMENT_VAL_KEY, "Comment Value");
        types.put(Globals.COMMENT_OPEN_KEY, "Open comment scope");
        types.put(Globals.COMMENT_CLOSE_KEY, "Close comment scope");
        types.put(Globals.SPACE_KEY, "Space");
   //     types.put(Globals.SEMICOLON_KEY, "Separator");
    }



    public String getTokenType(int i) {
        if (types.containsKey(i)) {
            return types.get(i);
        }
        return "";
        /*else {
            throw new Exception("ERROR: unknown word");
        }*/
    }
}
