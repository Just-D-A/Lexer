package io;

/*import org.volgatech.todolist.domain.list.List;
import org.volgatech.todolist.io.command.*;
*/

import domain.Token;
import domain.tokenType.TokenType;
import globals.Globals;
import io.doubleSymbols.*;
import io.identifiers.Identifiers;
import io.keyWords.*;
import io.keyWords.Double;
import io.numbers.Numbers;
import io.specialSymbols.*;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Vector;

public class Reader {

    private Vector<Token> tokenList;

    private HashMap<String, KeyWord> keyWords;
    private HashMap<Character, SpecialSymbols> specialSymbols;
    private HashMap<String, DoubleSymbols> doubleSymbols;

    private Numbers numbers;
    private Identifiers identifiers;


    public Reader() {
        tokenList = new Vector<>();

        keyWords = new HashMap<>();
        keyWords.put("write", new Write());
        keyWords.put("int", new Int());
        keyWords.put("double", new Double());

        specialSymbols = new HashMap<>();
        specialSymbols.put('+', new Plus());
        specialSymbols.put('-', new Minus());
        specialSymbols.put('/', new Division());
        specialSymbols.put('*', new Multiplication());
        specialSymbols.put(' ', new Space());

        doubleSymbols = new HashMap<>();
        doubleSymbols.put("/*", new OpenComment());
        doubleSymbols.put("*/", new CloseComment());

        numbers = new Numbers();
        identifiers = new Identifiers();
    }

    public void start(String fileName) throws Exception {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(fileName));
        String line;
        int lineIndex = 1;
        Token token;

        do {
            line = reader.readLine();

            try {
                if (line.endsWith("exit")) {
                    break;
                }
                char[] charLine = line.toCharArray();
                String substring = "";

                for (int i = 0; i < charLine.length; i++) { //посимвольно рассматриваем строку

                    if (charLine[i] == Globals.STRING_OPEN_SYMBOL) { //проверка на наличие ' " ' - открытия строки
                        token = checkSubstring(substring, lineIndex, i);
                        if (token != null) {
                            tokenList.add(token);
                        }
                        substring = "";
                        String str = "";
                        int indexBegin = i;
                        int indexLine = lineIndex;

                        for (int y = i + 1; y < charLine.length; y++) {
                            str += charLine[y];
                        }

                        int index = str.indexOf(Globals.STRING_CLOSE_SYMBOL);

                        while (index == -1) {
                            line = reader.readLine();
                            lineIndex++;
                            str += line;
                            index = str.indexOf(Globals.STRING_CLOSE_SYMBOL);
                        }

                        str = '"' + str;
                        if (index + 1 < str.length()) {
                            i = line.length() - (str.length() - index) + 1;
                            str = str.substring(0, index + 1);
                        } else {
                            line = reader.readLine();
                            i = 0;
                        }
                        str = str + '"';
                        token = new Token(Globals.STRING_VAL_KEY, str, indexLine, indexBegin);
                        tokenList.add(token);

                        charLine = line.toCharArray();
                    } else if (specialSymbols.containsKey(charLine[i])) { //проверка на спец символы
                        if (((i + 1) < charLine.length) && (doubleSymbols.containsKey("" + charLine[i] + charLine[i + 1]))) { //проверить следующий символ "/*"
                            String doubleStr = "" + charLine[i] + charLine[i + 1];
                            token = checkSubstring(substring, lineIndex, i);
                            if (token != null) {
                                tokenList.add(token);
                            }
                            DoubleSymbols doubleSymbol = doubleSymbols.get(doubleStr);
                            tokenList.add(doubleSymbol.execute(doubleStr, lineIndex, i));
                            substring = "";
                            i++;

                            //_________обработка комментария____________-
                            if (doubleStr.equals(Globals.COMMENT_OPEN_SYMBOL)) {
                                int indexBegin = i - 1;
                                int indexLine = lineIndex;

                                String str = "";

                                for (int y = i + 1; y < charLine.length; y++) {
                                    str += charLine[y];
                                }

                                int index = str.indexOf(Globals.COMMENT_CLOSE_SYMBOL);

                                while (index == -1) {
                                    line = reader.readLine();
                                    lineIndex++;
                                    str += line;
                                    index = str.indexOf(Globals.COMMENT_CLOSE_SYMBOL);
                                }


                                if (index + 1 < str.length()) {
                                    i = line.length() - (str.length() - index) + 1;
                                    str = str.substring(0, index);
                                } else {
                                    line = reader.readLine();
                                    i = 0;
                                }
                               /* System.out.println("Next i = " + i);
                                System.out.println("Next char = " + charLine[i]);*/


                                token = new Token(Globals.COMMENT_VAL_KEY, str, indexLine, indexBegin);
                                tokenList.add(token);
                                token = new Token(Globals.COMMENT_CLOSE_KEY, Globals.COMMENT_CLOSE_SYMBOL, lineIndex, i);
                                tokenList.add(token);

                                charLine = line.toCharArray();
                            }
                            //_____________________
                        } else { //обработка спецсимвола
                            token = checkSubstring(substring, lineIndex, i);
                            if (token != null) {
                                tokenList.add(token);
                            }
                            SpecialSymbols specialSymbol = specialSymbols.get(charLine[i]);
                            tokenList.add(specialSymbol.execute("" + charLine[i], lineIndex, i));
                            substring = "";
                        }
                    } else {
                        substring += charLine[i];
                    }
                }
                token = checkSubstring(substring, lineIndex, charLine.length);
                if (token != null) {
                    tokenList.add(token);
                }
                lineIndex++;

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (line != null);

        for (Token t : tokenList) {
            t.writeToken();
        }
    }

    private Token checkSubstring(String subStr, int lineInd, int ind) throws Exception { //Проверка строки
        if (subStr.equals("")) {
            return null;
        }
        ind -= subStr.length();
        Token token;

        if (keyWords.containsKey(subStr)) {
            KeyWord keyWord = keyWords.get(subStr);
            token = keyWord.execute(subStr, lineInd, ind);
            return token;
        }
        char[] charArr = subStr.toCharArray();

        if (charArr[0] == Globals.FIRST_VARIABLE_SYMBOL) {
            token = identifiers.checkIdentifier(subStr, lineInd, ind);
            if (token != null) {
                return token;
            }
        }
        token = numbers.checkNum(subStr, lineInd, ind);

        if (token != null) {
            return token;
        }

        token = new Token(Globals.ERROR_KEY, subStr, lineInd, ind);//token.createErrorToken(subStr, lineInd, ind);
        token.writeToken();
        return token;
        //throw new Exception(subStr + " unknown word");
    }


}
