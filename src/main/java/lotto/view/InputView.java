package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Money;
import lotto.message.InputMessage;
import lotto.util.Validator;

public class InputView {
    public int getLottoPurchaseAmount() {
        System.out.println(InputMessage.INPUT_PURCHASE_AMOUNT.getMessage());
        String input = Console.readLine();
        Validator.validateLottoPurchaseAmount(input);
        return Integer.parseInt(input);
    }

    public String getWinningNumbers() {
        System.out.println(InputMessage.INPUT_WINNING_NUMBERS.getMessage());

        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println(InputMessage.INPUT_BONUS_NUMBER.getMessage());

        return Console.readLine();
    }
}
