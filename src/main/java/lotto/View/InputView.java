package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.GameMessage;
import lotto.validation.Validator;

public class InputView {
    public static String getAmount() {
        System.out.println(GameMessage.INPUT_AMOUNT.getMessage());

        String input = Console.readLine();

        return input;
    }

    public static String getWinningNumber() {
        System.out.println(GameMessage.INPUT_WINNING_NUMBER.getMessage());

        String input = Console.readLine();

        return input;
    }

    public static int getBonusNumber() {
        int input = -1;

        return input;
    }
}
