package lotto.view;

import static lotto.exception.LottoErrorCode.BLANK_INPUT;
import static lotto.exception.LottoErrorCode.NOT_INTEGER_INPUT;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoException;

public class InputView {

    private final static String LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요";

    public static int inputLottoPurchaseAmount() {
        System.out.println(LOTTO_PURCHASE_AMOUNT_MESSAGE);

        return convertToInteger(getInput());
    }

    private static int convertToInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new LottoException(NOT_INTEGER_INPUT);
        }
    }

    private static String getInput() {
        final String input = Console.readLine();
        validateNotBlank(input);
        return input;
    }

    private static void validateNotBlank(final String input) {
        if (input == null || input.isEmpty()) {
            throw new LottoException(BLANK_INPUT);
        }
    }

}