package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.CustomNullPointAmountException;
import lotto.exception.CustomNumberFormatAmountException;
import lotto.exception.amount.AmountExceptionStatus;
import lotto.view.output.OutputView;

public class InputView {

    private final OutputView outputView;

    public InputView(final OutputView outputView) {
        this.outputView = outputView;
    }

    public int readAmount() {
        outputView.printReadAmountMessage();
        return parseAmount(readLine());
    }

    private int parseAmount(final String amount) {
        try {
            return Integer.parseInt(isNull(amount));
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatAmountException(AmountExceptionStatus.READ_IS_NOT_NUMERIC);
        }
    }

    private String isNull(final String amount) {
        try {
            return amount.trim();
        } catch (NullPointerException e) {
            throw new CustomNullPointAmountException(AmountExceptionStatus.READ_IS_NULL);
        }
    }

    private String readLine() {
        return Console.readLine();
    }
}
