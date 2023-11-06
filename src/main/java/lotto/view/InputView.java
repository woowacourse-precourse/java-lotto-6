package lotto.view;

import static lotto.common.constant.ErrorConstant.ERROR_PREFIX;
import static lotto.view.InputGuideMessage.LOTTO_PURCHASE_AMOUNT_INPUT_GUIDE;

import java.math.BigDecimal;
import lotto.common.validator.NumericValidator;
import lotto.common.validator.StringLiteralValidator;
import lotto.domain.LottoPurchaseAmount;
import lotto.view.printer.Printer;
import lotto.view.reader.Reader;

public class InputView {

    private final Reader reader;
    private final Printer printer;

    public InputView(Reader reader, Printer printer) {
        this.reader = reader;
        this.printer = printer;
    }

    public LottoPurchaseAmount inputLottoPurchaseAmount() {
        printer.printLine(LOTTO_PURCHASE_AMOUNT_INPUT_GUIDE.getGuide());
        String input = reader.readLine();

        validatePurchaseAmountInput(input);

        return new LottoPurchaseAmount(new BigDecimal(Integer.parseInt(input)));
    }

    private void validatePurchaseAmountInput(String input) {
        validatePositiveInteger(input, "%s 구입 금액은 양수여야 합니다.".formatted(ERROR_PREFIX));
        validateDivisible(
                Integer.parseInt(input),
                LottoPurchaseAmount.AMOUNT_CLASSIFICATION_THRESHOLD,
                "%s 구입 금액은 %d원 단위로 입력해주세요.".formatted(ERROR_PREFIX, LottoPurchaseAmount.AMOUNT_CLASSIFICATION_THRESHOLD)
        );
    }

    private void validateDivisible(int dividend, int divisor, String message) {
        try {
            NumericValidator.validateDivisible(dividend, divisor);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(message);
        }
    }

    private void validatePositiveInteger(String input, String message) {
        try {
            StringLiteralValidator.validatePositiveInteger(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(message);
        }
    }

}
