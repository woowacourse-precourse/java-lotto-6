package lotto.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

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
