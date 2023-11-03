package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.InputMessage;

public class Input {
    public static int readAmount() {
        System.out.println(InputMessage.AMOUNT.getMessage());
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
