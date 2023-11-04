package lotto.domain;

import static java.lang.String.valueOf;
import static lotto.exception.ErrorMessage.IS_NOT_MULTIPLE_OF_THOUSAND;
import static lotto.validator.InputValidator.validateEmpty;
import static lotto.validator.InputValidator.validateNumber;

import lotto.exception.LottoException;
import lotto.parser.Parser;

public class PurchaseAmount {
    private static int purchaseAmount ;
    private static final int UNIT_PRICE = 1000;
    public static int count;

    public static PurchaseAmount creat(final String purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    private PurchaseAmount(final String input) {

        validateNumber(input);
        validateEmpty(input);

        this.purchaseAmount = Parser.parseInt(input);

        ValidateMultipleOfThousand(purchaseAmount);

        this.count = calculateLottoCount(purchaseAmount);
    }

    // 1000원 단위로 입력되었는지 검증
    private void ValidateMultipleOfThousand(int purchaseAmount) {
        if (isMultipleOfThousand(purchaseAmount)) {
            throw LottoException.of(IS_NOT_MULTIPLE_OF_THOUSAND);
        }
    }
    public boolean isMultipleOfThousand(int purchaseAmount) {
        return (purchaseAmount % UNIT_PRICE) != 0;
    }

    public static int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / UNIT_PRICE;
    }

}
