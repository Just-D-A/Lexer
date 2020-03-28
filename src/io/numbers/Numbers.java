package io.numbers;

import domain.Token;
import globals.Globals;

public class Numbers {
    private char[] num;
    private Token token = new Token();

    public Token checkNum(String number, int line, int position) throws Exception {
        //System.out.println("Check is number");
        this.num = number.toCharArray();
        if(checkIntNum()) {
            return new Token(Globals.INTEGER_KEY, number, line, position);
            /*token.writeToken();
            return true;*/
        }
        if(checkDoubleNum()) {
            //создание токена
            return new Token(Globals.DOUBLE_KEY, number, line, position);
            /*token.writeToken();
            return true;*/
        }
        if(check2Num()) {
            //создание токена
            return  new Token(Globals.BINARY_KEY, number, line, position);
            /*token.writeToken();
            return true;*/
        }
        if(check16Num()) {
            //создание токена
            return new Token(Globals.BINARY_KEY, number, line, position);
            /*token.writeToken();
            return true;*/
        }
        //Token token = new Token();
        return null;
    }

    private boolean checkIntNum() {
        for(char n: num) {
            if(!((n >= '0') && (n <= '9'))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDoubleNum() {
        boolean hasOnePoint = false;
        for(char n: num) {
            if(!(((n >= '0') && (n <= '9')) || ((n == '.') && (!hasOnePoint)) )) {
                return false;
            }
            if(n == '.') {
                hasOnePoint = true;
            }
        }
        return true;
    }

    private boolean check2Num() throws Exception {
        if (num[0] == Globals.FIRST_2_NUM_SYMBOL) { //символ
            for (int i = 1; i < num.length; i++) {
                if(!((num[i] == '0') || (num[i] == '1'))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean check16Num() throws Exception {
        if (num[0] == Globals.FIRST_16_NUM_SYMBOL) { //символ
            for (int i = 1; i < num.length; i++) {
                if(!(((num[i] >= '0') && (num[i] <= '9')) || ((num[i] >= 'A') && (num[i] <= 'F')))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
