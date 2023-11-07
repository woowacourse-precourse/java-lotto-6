package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.BuyAmountValidator;

import static lotto.constants.InputMessages.*;

public class InputView {
    public BuyAmountValidator readBuyAmount() {
        System.out.println(INPUT_BUY_AMOUNT.getMessage());
        return new BuyAmountValidator(Console.readLine());
    }

    public String readWinNumber() {
        System.out.println(INPUT_WIN_NUMBER.getMessage());
        return Console.readLine();
    }

    public String readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
