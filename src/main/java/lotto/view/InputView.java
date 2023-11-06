package lotto.view;

import static lotto.util.message.Guide.PURCHASE_AMOUNT;
import static lotto.util.message.Guide.WINNING_NUMBER;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String purchase() {
        System.out.println(PURCHASE_AMOUNT.getMessage());
        return Console.readLine();
    }

    public static String winningLotto() {
        System.out.println(WINNING_NUMBER.getMessage());
        return Console.readLine();
    }
}
