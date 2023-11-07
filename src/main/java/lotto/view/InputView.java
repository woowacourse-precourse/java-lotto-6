package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String input(String message) {
        System.out.println(message);
        String input = Console.readLine();
        System.out.println();

        return input;
    }
}
