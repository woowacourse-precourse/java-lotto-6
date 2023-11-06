package lotto.view;

import static lotto.view.ViewMessage.REQUEST_BONUS_NUMBER;
import static lotto.view.ViewMessage.REQUEST_INPUT_MONEY;
import static lotto.view.ViewMessage.REQUEST_WINNER_NUMBERS;

public class LottoInputView implements View {
    LottoInputView() {
    }

    public void requestMoney() {
        System.out.println(REQUEST_INPUT_MONEY.getMessage());
    }

    public void requestWinnerNumbers() {
        System.out.println(REQUEST_WINNER_NUMBERS.getMessage());
    }

    public void requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER.getMessage());
    }
}
