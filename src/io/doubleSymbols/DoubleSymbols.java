package io.doubleSymbols;

import domain.Token;

public abstract class DoubleSymbols {

    public abstract Token execute(String val, int line, int position) throws Exception;
}