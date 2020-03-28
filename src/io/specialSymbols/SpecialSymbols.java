package io.specialSymbols;


import domain.Token;

public abstract class SpecialSymbols{

    public abstract Token execute(String val, int line, int position) throws Exception;

}