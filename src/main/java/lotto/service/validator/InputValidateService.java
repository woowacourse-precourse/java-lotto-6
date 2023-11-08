package lotto.service.validator;

import lotto.util.Constant;
import lotto.view.ErrorMessage;

import java.util.List;

public class InputValidateService {

    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % Constant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT);
        }
    }

    public static void validateNumbers(List<Integer> numbers) {

        if (numbers.size() != Constant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_COUNT);
        }

        if (numbers.stream().distinct().count() != Constant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBERS);
        }

        if (numbers.stream()
                .anyMatch(number -> number < Constant.MIN_LOTTO_NUMBER || number > Constant.MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE);
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < Constant.MIN_LOTTO_NUMBER || bonusNumber > Constant.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE);
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBERS);
        }
    }
}
