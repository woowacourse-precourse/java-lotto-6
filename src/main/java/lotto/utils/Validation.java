package lotto.utils;

import java.util.List;
import lotto.constants.LottoRules;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.constants.ExceptionMessages;

public class Validation {

    public static void validatePurchaseAmount(int purchaseAmount) {
        validateNumberInRange(purchaseAmount, LottoRules.PURCHASE_AMOUNT_MIN.getValue(), LottoRules.PURCHASE_AMOUNT_MAX.getValue());
        validateNumberMultipleOf(purchaseAmount, LottoRules.LOTTO_PRICE.getValue());
    }
    public static void validateLotto(List<Integer> winningNumbers) {
        validateListNumberCount(winningNumbers, LottoRules.LOTTO_NUMBER_COUNT.getValue());
        validateListNumberInRange(winningNumbers, LottoRules.MIN_LOTTO_NUMBER.getValue(), LottoRules.MAX_LOTTO_NUMBER.getValue());
        validateListNumberNotDuplicated(winningNumbers);
    }

    public static void validateBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        validateNumberInRange(bonusNumber.bonusNumber(), LottoRules.MIN_LOTTO_NUMBER.getValue(), LottoRules.MAX_LOTTO_NUMBER.getValue());
        validateBonusNumberNotInWinningNumber(bonusNumber.bonusNumber(), lotto.getNumbers());
    }
    public static void validateStringToInteger(String string) {
        if (string.isEmpty()) {
            ExceptionMessages.STRING_TO_INTEGER.throwException();
        }
        if (string.isBlank()) {
            ExceptionMessages.STRING_TO_INTEGER.throwException();
        }
        if (!string.chars().allMatch(Character::isDigit)) {
            ExceptionMessages.STRING_TO_INTEGER.throwException();
        }
    }

    public static void validateNumberInRange(int number, int min, int max) {
        if (number < min || number > max) {
            ExceptionMessages.NUMBER_IN_RANGE.throwException(min, max);
        }
    }

    public static void validateListNumberInRange(List<Integer> number, int min, int max) {
        if (number.stream().anyMatch(n -> n < min || n > max)) {
            ExceptionMessages.NUMBER_IN_RANGE.throwException(min, max);
        }
    }

    public static void validateNumberMultipleOf(int number, int multiple) {
        if (number % multiple != 0) {
            ExceptionMessages.INPUT_MULTIPLE_NUMBER.throwException(multiple);
        }
    }

    public static void validateListNumberNotDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            ExceptionMessages.DUPLICATED_NUMBER_IN_LIST.throwException();
        }
    }

    public static void validateListNumberCount(List<Integer> numbers, int count) {
        if (numbers.size() != count) {
            ExceptionMessages.INPUT_COUNT.throwException(count);
        }
    }

    public static void validateBonusNumberNotInWinningNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            ExceptionMessages.DUPLICATED_NUMBER_IN_LIST.throwException();
        }
    }
}
