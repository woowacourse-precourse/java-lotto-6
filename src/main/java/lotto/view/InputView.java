package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.validator.PurchaseLottoValidator;
import lotto.util.Util;

public class InputView {
    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    public int inputPurchaseLotto() {
        try {
            System.out.print(Message.INPUT_PURCHASE_LOTTO.message);
            int purchase = Util.convertStringToInt(Console.readLine());
            new PurchaseLottoValidator().validate(purchase);
            return purchase;
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception);
            return inputPurchaseLotto();
        }
    }

    private void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    private enum Message {
        INPUT_PURCHASE_LOTTO("구입금액을 입력해 주세요.\n");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
