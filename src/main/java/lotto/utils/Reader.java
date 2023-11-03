package lotto.utils;

import camp.nextstep.edu.missionutils.Console;

public class Reader {
    private Reader() {

    }

    public static String readLine() {
        return Console.readLine();
    }

    public static void close() {
        Console.close();
    }
}
