package lotto.view;

import static lotto.message.InputErrorMessage.INVALID_INPUT_FORMAT;
import static lotto.message.InputErrorMessage.INVALID_INPUT_MAXIMUM;
import static lotto.message.InputErrorMessage.INVALID_INPUT_NEGATIVE;
import static lotto.message.InputErrorMessage.INVALID_INPUT_UNIT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    int requestLottoPurchaseAmount() {
        System.out.println(PURCHASE_MESSAGE);
        try {
            int lottoPurchaseAmount = Integer.parseInt(Console.readLine().trim());
            validateLottoPurchaseAmount(lottoPurchaseAmount);
            return lottoPurchaseAmount;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format(INVALID_INPUT_FORMAT, "숫자"));
        }
    }

    private static void validateLottoPurchaseAmount(int lottoPurchaseAmount) {
        if (lottoPurchaseAmount < 0) {
            throw new IllegalArgumentException(INVALID_INPUT_NEGATIVE);
        }

        if (lottoPurchaseAmount >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException(INVALID_INPUT_MAXIMUM);
        }

        int reminder = lottoPurchaseAmount % 1000;
        if (reminder > 0) {
            throw new IllegalArgumentException(INVALID_INPUT_UNIT);
        }
    }
}
