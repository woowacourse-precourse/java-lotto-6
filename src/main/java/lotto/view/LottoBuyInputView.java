package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ErrorMessage;

public class LottoBuyInputView {

    private static final String PURCHASE_AMOUNT_PROMPT_MESSAGE = "구입할 Lotto 금액을 입력해 주세요.";
    private static final int DENOMINATION = 1000;

    public int requestLottoPurchaseAmount() {
        printRequestLottoPurchaseAmount();
        int amount = parseInt(Console.readLine());
        checkIsMultipleOfDenomination(amount, DENOMINATION);
        return amount;
    }

    private static void printRequestLottoPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_PROMPT_MESSAGE);
    }

    private void checkIsMultipleOfDenomination(int value, int denomination) {
        if (value % denomination != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_AMOUNT.getMessage());
        }
    }

    private int parseInt(String requestAmount) {
        int amount;
        try {
            amount = Integer.parseInt(requestAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_FORMAT.getMessage());
        }
        return amount;
    }
}
