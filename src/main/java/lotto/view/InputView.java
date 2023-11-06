package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private enum InputMessage {
        INPUT_PURCHASE_MONEY("구입금액을 입력해 주세요.");

        private final String message;

        InputMessage(String message) {
            this.message = message;
        }
    }

    public String inputPurchaseMoney() {
        System.out.println(InputMessage.INPUT_PURCHASE_MONEY.message);
        return Console.readLine();
    }
}