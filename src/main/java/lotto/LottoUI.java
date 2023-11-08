package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoUI {
    public static String readLine(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
