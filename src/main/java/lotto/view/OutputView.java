package lotto.view;

import static lotto.util.message.ViewMessages.INPUT_BONUS_NUMBER;
import static lotto.util.message.ViewMessages.INPUT_USER_MONEY;
import static lotto.util.message.ViewMessages.INPUT_WINNING_NUMBERS;
import static lotto.util.message.ViewMessages.OUTPUT_LOTTO_AMOUNT_MESSAGE;
import static lotto.util.message.ViewMessages.OUTPUT_LOTTO_NUMBERS;

import lotto.model.Lotto;
import lotto.model.UserLotto;
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

    public void printUserLotto(UserLotto userLotto) {
        userLotto.getLottos().forEach(this::printLottoNumbers);
    }

    private void printLottoNumbers(Lotto lotto) {
        printf(OUTPUT_LOTTO_NUMBERS + "\n", lotto.getNumbers().toArray());
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void printf(String format, Object... args) {
        System.out.printf(format, args);
    }
}
