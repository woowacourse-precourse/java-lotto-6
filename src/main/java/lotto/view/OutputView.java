package lotto.view;

import static lotto.util.message.ViewMessages.INPUT_BONUS_NUMBER;
import static lotto.util.message.ViewMessages.INPUT_USER_MONEY;
import static lotto.util.message.ViewMessages.INPUT_WINNING_NUMBERS;
import static lotto.util.message.ViewMessages.OUTPUT_LOTTO_AMOUNT_MESSAGE;
import lotto.model.UserMoney;

public class OutputView {
    public void printUserMoneyInputGuide() {
        println(INPUT_USER_MONEY);
    }

    public void printWinningNumbersGuide() {
        println(INPUT_WINNING_NUMBERS);
    }

    public void printBonusNumberGuide() {
        println(INPUT_BONUS_NUMBER);
    }

    public void printLottoAmount(UserMoney userMoney) {
        printf(OUTPUT_LOTTO_AMOUNT_MESSAGE + "\n", userMoney.getLottoAmount());
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void printf(String format, Object object) {
        System.out.printf(format, object);
    }
}
