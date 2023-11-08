package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.GameMessage;
import lotto.validation.Validator;

public class InputView {
    public String getPrice() {
        System.out.println(GameMessage.INPUT_PRICE.getMessage());

        String input = Console.readLine();

        return input;
    }

    public String getWinningNumber() {
        System.out.println(GameMessage.INPUT_WINNING_NUMBER.getMessage());

        String input = Console.readLine();

        return input;
    }

    public int getBonusNumber() {
        int input = -1;

        return input;
    }
}
