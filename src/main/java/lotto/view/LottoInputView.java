package lotto.view;

import static lotto.view.ViewMessage.REQUEST_BONUS_NUMBER;
import static lotto.view.ViewMessage.REQUEST_INPUT_MONEY;
import static lotto.view.ViewMessage.REQUEST_WINNER_NUMBERS;

public class LottoInputView implements View {
    LottoInputView() {
    }

    /**
     * 구입 금액 입력 요청 메시지 출력 메서드.
     */
    public void requestMoney() {
        System.out.println(REQUEST_INPUT_MONEY.getMessage());
    }

    /**
     * 당첨 번호 입력 요청 메시지 출력 메서드.
     */
    public void requestWinnerNumbers() {
        System.out.println(REQUEST_WINNER_NUMBERS.getMessage());
    }

    /**
     * 보너스 번호 입력 요청 메시지 출력 메서드.
     */
    public void requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER.getMessage());
    }
}
