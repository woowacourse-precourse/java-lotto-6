package lotto.validator;

import java.util.List;
import lotto.Amount;
import lotto.manager.Exception;
import lotto.policy.LottoNumberGenerator;
import lotto.util.Util;

public class Validator {
    public static void validatePurchaseAmount(Amount purchaseAmount) {
        if (purchaseAmount.lessThan(Amount.DEFAULT_PURCHASE_AMOUNT)) {
            Exception.PURCHASE_AMOUNT_OUT_OF_RANGE.throwing();
        }

        if (!purchaseAmount.isMultipleOf(Amount.DEFAULT_PURCHASE_AMOUNT)) {
            Exception.PURCHASE_AMOUNT_WRONG_UNIT.throwing();
        }
    }

    public static void validateLottoNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            Exception.LOTTO_NUMBERS_COUNT_OUT_OF_RANGE.throwing();
        }
        if (!Util.isWithinRange(numbers, LottoNumberGenerator.MIN_NUMBER, LottoNumberGenerator.MAX_NUMBER)) {
            Exception.LOTTO_NUMBER_OUT_OF_RANGE.throwing();
        }
        if (Util.hasDuplicates(numbers)) {
            Exception.LOTTO_NUMBER_HAS_DUPLICATES.throwing();
        }
    }
}
