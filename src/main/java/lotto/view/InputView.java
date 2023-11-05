package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readString(String message) {
        System.out.println(message);
        String inputValue = Console.readLine();
//        validateString(inputValue);
        return inputValue;
    }

    public static int readInteger(String message) {
        System.out.println(message);
        String inputValue = Console.readLine();
//        validateInteger(inputValue);
        return Integer.parseInt(inputValue);
    }
}
