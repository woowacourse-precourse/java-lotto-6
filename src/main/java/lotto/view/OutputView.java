package lotto.view;

import static lotto.utils.GameMessage.REQUEST_AMOUNT;
import static lotto.utils.GameMessage.REQUEST_BONUS_NUMBER;
import static lotto.utils.GameMessage.REQUEST_WIN_NUMBERS;

public class OutputView {

    public void printRequestAmount() {
        System.out.println(REQUEST_AMOUNT.getMessage());
    }

    public void printRequestWinNumbers() {
        System.out.println(REQUEST_WIN_NUMBERS.getMessage());
    }

    public void printRequestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER.getMessage());
    }
}
