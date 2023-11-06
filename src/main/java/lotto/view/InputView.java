package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private enum InputMessage {
        REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
        REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
        REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

        private final String message;

        InputMessage(String message) {
            this.message = message;
        }
    }

    public int inputPurchaseAmount() {
        System.out.println(InputMessage.REQUEST_PURCHASE_AMOUNT.message);
        String userInputNumber = Console.readLine();

        return Integer.parseInt(userInputNumber);
    }
}
