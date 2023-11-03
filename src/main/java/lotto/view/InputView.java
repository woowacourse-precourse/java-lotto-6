package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Util;

public class InputView {
    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    public int inputPurchaseLotto() {
        System.out.print(Message.INPUT_PURCHASE_LOTTO.message);
        String input = Console.readLine();
        return Util.convertStringToInt(input);
    }

    private enum Message {
        INPUT_PURCHASE_LOTTO("구입금액을 입력해 주세요.\n");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
