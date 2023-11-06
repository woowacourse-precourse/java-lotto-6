package lotto.view;

import lotto.constant.errorMessage.amount.AmountExceptionStatus;
import lotto.constant.errorMessage.amount.NotNumericAmountException;
import lotto.view.reader.Reader;

public class InputView {

    private static final String PRINT_READ_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    private final Reader reader;

    public InputView(final Reader reader) {
        this.reader = reader;
    }

    public int readPurchaseAmount() {
        System.out.println(PRINT_READ_PURCHASE_AMOUNT);
        return convertToNumber(reader.readLine());
    }

    private int convertToNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new NotNumericAmountException(AmountExceptionStatus.PURCHASE_AMOUNT_IS_NOT_NUMERIC);
        }
    }
}
