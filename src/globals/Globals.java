package globals;

public class Globals {
    public static char     FIRST_VARIABLE_SYMBOL = '#';
    public static char        FIRST_2_NUM_SYMBOL = '$';
    public static char       FIRST_16_NUM_SYMBOL = '@';

    public static char        STRING_OPEN_SYMBOL = '"';
    public static char        STRING_CLOSE_SYMBOL = '"';
    public static String        COMMENT_OPEN_SYMBOL = "/*";
    public static String        COMMENT_CLOSE_SYMBOL = "*/";

    public static int                  ERROR_KEY = 0;
    public static int   ARITHMETIC_OPERATION_KEY = 1;
    public static int             IDENTIFIER_KEY = 2;
    public static int               KEY_WORD_KEY = 3;
    public static int   COMPARISON_OPERATION_KEY = 4;
    public static int                INTEGER_KEY = 5;
    public static int                 DOUBLE_KEY = 6;
    public static int                 BINARY_KEY = 7;
    public static int              SEMICOLON_KEY = 8;
    public static int             STRING_VAL_KEY = 9;
    public static int            COMMENT_VAL_KEY = 10;
    public static int           COMMENT_OPEN_KEY = 11;
    public static int          COMMENT_CLOSE_KEY = 12;
    public static int                  SPACE_KEY = 13;


}
/*
types.put(0,  "Error");
        types.put(1,  "Separator");
        types.put(2,  "OpenedComment");
        types.put(3,  "ClosedComment");
        types.put(4,  "LineComment");
        types.put(5,  "ArithmeticOperation");
        types.put(6,  "Identifier");
        types.put(7,  "KeyWord");
        types.put(8,  "ComparisonOperation");
        types.put(9,  "LogicalOperation");
        types.put(10, "BitOperation");
        types.put(11, "Appropriation");
        types.put(12, "Integer");
        types.put(13, "Float");
        types.put(14, "Hexadecimal");
        types.put(15, "Binary");
        types.put(16, "BigInteger");
        types.put(17, "Separator");
        types.put(18, "Separator");
 */