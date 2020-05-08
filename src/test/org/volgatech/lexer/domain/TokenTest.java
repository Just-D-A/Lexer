package test.org.volgatech.lexer.domain;

import main.org.volgatech.lexer.Globals.Globals;
import main.org.volgatech.lexer.domain.Token;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TokenTest {
    @Test
    public void testCreateToken() {
        String dealDescription = "some description";
        String openScope = "(";
        int line = 1;
        int position = 1;
        Token token = new Token(Globals.OPEN_SCOPE_KEY, openScope, line, position);
        assertEquals(Globals.OPEN_SCOPE_KEY, token.getTokenType());
        assertEquals(openScope, token.getValue());
        assertEquals(line, token.getLine());
        assertEquals(position, token.getPosition()-1);
    }

    @Test
    public void getUnknownTokenTypeTest() throws Exception {
        int unknownIndex = 100;
        String openScope = "(";
        int line = 1;
        int position = 1;
        Token token = new Token(unknownIndex, openScope, line, position);
        assertThrows(Exception.class, () -> {token.writeToken();});
    }

}
