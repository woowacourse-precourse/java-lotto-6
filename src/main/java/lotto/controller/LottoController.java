package lotto.controller;

import static lotto.utils.StringUtils.parseInt;
import static lotto.view.InputMessage.HOW_MUCH_MONEY_FOR_LOTTO_PURCHASE;
import static lotto.view.InputView.readInput;

public class LottoController {
    public int receiveMoney() {
        String userInput = readInput(HOW_MUCH_MONEY_FOR_LOTTO_PURCHASE.getInputMessage());
        return parseInt(userInput);
    }
}
