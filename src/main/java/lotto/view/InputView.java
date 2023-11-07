package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorCode;
import lotto.exception.LottoGameException;

public class InputView {
    public static int readPurchaseAmount() {
        String inputPurchaseAmount = Console.readLine();
        return convertInputPurchaseAmountToInt(inputPurchaseAmount);
    }

    private static int convertInputPurchaseAmountToInt(String inputPurchaseAmount) {
        try {
            return Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException exception) {
            throw new LottoGameException(ErrorCode.NON_INT_PURCHASE_AMOUNT);
        }
    }
}
