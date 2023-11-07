package lotto.utils;

import camp.nextstep.edu.missionutils.Console;

public class CustomScanner {
    public static String getReadLine() {
        String inputValue = Console.readLine();
        Console.close();
        return inputValue;
    }
}
