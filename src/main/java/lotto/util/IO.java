package lotto.util;

import camp.nextstep.edu.missionutils.Console;

public class IO {
    public static void printNoticeln(String ment) {
        System.out.println(ment);
    }


    public static String input() {
        String inputString= Console.readLine();
        return inputString;
    }
}
