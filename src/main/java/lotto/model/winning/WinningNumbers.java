package lotto.model.winning;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers {
    private static final String DUPLICATED_BONUS_NUMBER_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 다른 번호여야 합니다.";
    private static final String DELIMITER_REGEX = ",";

    private final List<Integer> numbers;
    private int bonusNumber;

    public WinningNumbers(String inputNumbers) {
        for (WinningNumberValidator validator : WinningNumberValidator.values()) {
            validator.validate(inputNumbers);
        }
        this.numbers = convertToNumbers(inputNumbers);
    }

    public void addBonusNumber(String bonusNumber) {
        for (BonusNumberValidator validator : BonusNumberValidator.values()) {
            validator.validate(bonusNumber);
        }
        validateDuplicatedBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private List<Integer> convertToNumbers(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(DELIMITER_REGEX))
                .map(Integer::parseInt)
                .toList();
    }


    private void validateDuplicatedBonusNumber(String bonusNumber) {
        if (numbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
