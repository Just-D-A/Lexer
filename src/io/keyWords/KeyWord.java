package io.keyWords;

import domain.Token;

public abstract class KeyWord {

    KeyWord() {
    }

    public abstract Token execute(String val, int line, int position) throws Exception;
}