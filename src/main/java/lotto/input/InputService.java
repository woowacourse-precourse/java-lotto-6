package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class InputService {
    public static String winNumber() {
        return Console.readLine();
    }

    public static String provideBonusNumber() {
        return Console.readLine();
    }

    public static String purchasePrice() {
        return Console.readLine();
    }
    public static void close() {
        Console.close();
    }
}
