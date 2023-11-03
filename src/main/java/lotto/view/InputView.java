package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.ExceptionMessage;
import lotto.util.Util;

public class InputView {
    private static final int LOTTO_UNIT = 1000;
    private static final int MIN_PURCHASE_LOTTO = 1000;
    private static final int MAX_PURCHASE_LOTTO = 2147483000;

    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    public int inputPurchaseLotto() {
        System.out.print(Message.INPUT_PURCHASE_LOTTO.message);
        String input = Console.readLine();
        validatePurchaseLotto(input);
        return Util.convertStringToInt(input);
    }

    private void validatePurchaseLotto(String input) {
        int purchase = Util.convertStringToInt(input);
        validatePurchaseLottoRange(purchase);
        validatePurchaseLottoUnit(purchase);
    }

    private void validatePurchaseLottoRange(int purchase) {
        if (purchase < MIN_PURCHASE_LOTTO || purchase > MAX_PURCHASE_LOTTO) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_PURCHASE_RANGE.getMessage());
        }
    }

    private void validatePurchaseLottoUnit(int purchase) {
        if (purchase % LOTTO_UNIT != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_PURCHASE_UNIT.getMessage());
        }
    }

    private enum Message {
        INPUT_PURCHASE_LOTTO("구입금액을 입력해 주세요.\n");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
