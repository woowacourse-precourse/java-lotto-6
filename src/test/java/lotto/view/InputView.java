package lotto.view;

import lotto.constant.errorMessage.amount.AmountExceptionStatus;
import lotto.constant.errorMessage.amount.NotNumericAmountException;
import lotto.constant.errorMessage.amount.NullAmountException;
import lotto.view.reader.Reader;

public class InputView {

    private static final String PRINT_READ_AMOUNT = "구입금액을 입력해 주세요.";

    private final Reader reader;

    public InputView(final Reader reader) {
        this.reader = reader;
    }

    public int readAmount() {
        System.out.println(PRINT_READ_AMOUNT);
        return convertToNumber(reader.readLine());
    }

    private int convertToNumber(String input) {
        try {
            return Integer.parseInt(checkAmountIsNull(input));
        } catch (NumberFormatException e) {
            throw new NotNumericAmountException(AmountExceptionStatus.AMOUNT_IS_NOT_NUMERIC);
        }
    }

    private String checkAmountIsNull(String input) {
        try {
            return input.trim();
        } catch (NullPointerException e) {
            throw new NullAmountException(AmountExceptionStatus.AMOUNT_IS_NULL);
        }
    }
}
