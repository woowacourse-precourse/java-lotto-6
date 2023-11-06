package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Utils {
    public static String input(){
        return Console.readLine();
    }

    public static boolean isChar(char ch){
        return '0' <= ch && ch <= '9';
    }
}
