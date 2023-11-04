package lotto.util;

import camp.nextstep.edu.missionutils.Console;

public class Util {
    public static double revertToDouble(String number) {
        return Double.parseDouble(number);
    }

    public static String readInput() {
        return Console.readLine();
    }

}
