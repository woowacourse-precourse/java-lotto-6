package lotto.validation;

import static lotto.validation.enumType.BonusNumber.DUPLICATION_BONUS_NUMBER;

import java.util.Arrays;
import java.util.List;

public class BonusNumberInputValidator {

    public void validateBonusNumberDuplication(String numbers, String number) {
        List<Integer> winningNumbers = stringToCollection(numbers);
        int bonusNumber = Integer.parseInt(number);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATION_BONUS_NUMBER.getMessage());
        }
    }

    private List<Integer> stringToCollection(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}