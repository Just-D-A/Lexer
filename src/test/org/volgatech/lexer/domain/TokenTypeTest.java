package test.org.volgatech.lexer.domain;

import main.org.volgatech.lexer.domain.TokenType;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TokenTypeTest {
    @Test
    public void getTokenTypeTest() throws Exception {
        TokenType tokenType = new TokenType();
        String waited = "Error";
        assertEquals(waited, tokenType.getTokenType(0));
    }

    @Test
    public void getUnknownTokenTypeTest() throws Exception {
        TokenType tokenType = new TokenType();
        int unknownIndex = 100;
        assertThrows(Exception.class, () -> {tokenType.getTokenType(unknownIndex);});
    }
}
