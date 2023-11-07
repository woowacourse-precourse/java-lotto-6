package lotto.controller;

import static lotto.utils.CalculationUtils.isDivisible;
import static lotto.utils.StringUtils.parseInt;
import static lotto.view.ErrorMessage.RECEIVED_MONEY_NOT_MULTIPLE_OF_1000;
import static lotto.view.InputMessage.HOW_MUCH_MONEY_FOR_LOTTO_PURCHASE;
import static lotto.view.InputView.readInput;

public class LottoController {
    public static final int ONE_LOTTO_PRICE = 1000;

    public int receiveMoney() {
        String userInput = readInput(HOW_MUCH_MONEY_FOR_LOTTO_PURCHASE.getInputMessage());
        validateReceivedMoney(userInput);
        return parseInt(userInput);
    }

    private void validateReceivedMoney(String userInput) {
        // 숫자 인지 검증
        int number = parseInt(userInput);

        if (!isDivisible(number, ONE_LOTTO_PRICE)) {
            throw new IllegalArgumentException(RECEIVED_MONEY_NOT_MULTIPLE_OF_1000.getErrorMessage());
        }
    }

}