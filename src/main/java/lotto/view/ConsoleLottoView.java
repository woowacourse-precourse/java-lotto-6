package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class ConsoleLottoView implements LottoView {

    enum Message {
        PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
        PURCHASE_DISPLAY_MESSAGE_PREFIX("개를 구매했습니다."),
        WINNING_NUMBER_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
        BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해 주세요."),
        RESULT_DISPLAY_MESSAGE("당첨 통계");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    @Override
    public String getPurchaseAmount() {
        display(Message.PURCHASE_AMOUNT_MESSAGE.getMessage());
        return input();
    }

    @Override
    public void displayPurchased() {
    }

    @Override
    public String getWinningNumbers() {
        return null;
    }

    @Override
    public String getBonusNumber() {
        return null;
    }

    @Override
    public void displayResult(HashMap<String, Integer> result) {

    }

    private void display(String message) {
        System.out.println(message);
    }

    private String input() {
        return Console.readLine();
    }
}
