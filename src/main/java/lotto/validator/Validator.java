package lotto.validator;

import java.util.List;
import lotto.Amount;
import lotto.manager.LottoException;
import lotto.policy.LottoNumbersGenerator;
import lotto.util.ListUtil;
import lotto.util.StringUtil;

public class Validator {
    public static void validatePurchaseAmount(Amount purchaseAmount) {
        if (purchaseAmount.lessThan(Amount.DEFAULT_PURCHASE_AMOUNT)) {
            LottoException.PURCHASE_AMOUNT_OUT_OF_RANGE.throwing();
        }
        if (!purchaseAmount.isMultipleOf(Amount.DEFAULT_PURCHASE_AMOUNT)) {
            LottoException.PURCHASE_AMOUNT_WRONG_UNIT.throwing();
        }
    }

    public static void validateLottoNumber(List<Integer> numbers) {
        if (numbers.size() != LottoNumbersGenerator.NUMBER_COUNT) {
            LottoException.LOTTO_NUMBERS_COUNT_OUT_OF_RANGE.throwing();
        }
        if (!ListUtil.isWithinRange(numbers, LottoNumbersGenerator.MIN_NUMBER, LottoNumbersGenerator.MAX_NUMBER)) {
            LottoException.LOTTO_NUMBER_OUT_OF_RANGE.throwing();
        }
        if (ListUtil.hasDuplicates(numbers)) {
            LottoException.LOTTO_NUMBER_HAS_DUPLICATES.throwing();
        }
    }

    public static void validateWinningLottoNumbers(String numbers) {
        List<Integer> winningNumbers = StringUtil.splitAndParseToIntList(numbers);
        validateLottoNumber(winningNumbers);
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (!ListUtil.isInRange(bonusNumber, LottoNumbersGenerator.MIN_NUMBER, LottoNumbersGenerator.MAX_NUMBER)) {
            LottoException.LOTTO_NUMBER_OUT_OF_RANGE.throwing();
        }
        if (winningNumbers.contains(bonusNumber)) {
            LottoException.BONUS_NUMBER_IN_WINNING_NUMBERS.throwing();
        }
    }
}
