package lotto.validation;

import static lotto.validation.constant.BonusInputConstant.DUPLICATION_BONUS_NUMBER;
import static lotto.validation.constant.BonusInputConstant.LOTTO_MAX_NUMBER;
import static lotto.validation.constant.BonusInputConstant.LOTTO_MIN_NUMBER;
import static lotto.validation.constant.BonusInputConstant.NUMBER_RANGE_MESSAGE;
import static lotto.validation.constant.BonusInputConstant.SPLIT_MESSAGE;

import java.util.Arrays;
import java.util.List;

public class BonusInputValidator {

    public void validateBonusNumberDuplication(String numbers, String number) {
        List<Integer> winningNumbers = stringToCollection(numbers);
        int bonusNumber = Integer.parseInt(number);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATION_BONUS_NUMBER.getMessage());
        }
    }

    private List<Integer> stringToCollection(String input) {
        return Arrays.stream(input.split(SPLIT_MESSAGE.getMessage()))
                .map(Integer::parseInt)
                .toList();
    }

    public void validateNumberRange(String input) {
        int number = Integer.parseInt(input);
        isValidNumberRange(number);
    }

    private void isValidNumberRange(int number) {
        if (number < LOTTO_MIN_NUMBER.getNumber() || number > LOTTO_MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(NUMBER_RANGE_MESSAGE.getMessage());
        }
    }

    public void validateBonusNumberInput(String winningNumbers, String input) {
        validateNumberRange(input);
        validateBonusNumberDuplication(winningNumbers, input);
    }
}