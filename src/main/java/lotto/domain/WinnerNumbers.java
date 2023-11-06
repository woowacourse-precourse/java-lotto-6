package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.LottoConstant;
import lotto.constant.Message;

public class WinnerNumbers {
    private static final String ERROR_NOT_NUMBERS_SIZE = Message.ERROR_NOT_NUMBERS_SIZE.getValue();
    private static final String ERROR_DUPLICATE_NUMBERS = Message.ERROR_DUPLICATE_NUMBERS.getValue();
    private static final String ERROR_BONUS_IN_WINNER_NUMBERS = Message.ERROR_BONUS_IN_WINNER_NUMBERS.getValue();
    private static final String ERROR_LOTTO_NUMBER_RANGE = Message.ERROR_LOTTO_NUMBER_RANGE.getValue();
    private static final int LOTTO_START_NUMBER = LottoConstant.LOTTO_START_NUMBER.getValue();
    private static final int LOTTO_END_NUMBER = LottoConstant.LOTTO_END_NUMBER.getValue();
    private static final int LOTTO_NUMBER_SIZE = LottoConstant.LOTTO_NUMBER_SIZE.getValue();

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinnerNumbers(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        validateNumberSize(numbers);
        validDuplicateNumber(numbers);
        validateBonusNumberInNumbers(numbers, bonusNumber);

        List<Integer> allNumbers = new ArrayList<>();
        allNumbers.addAll(numbers);
        allNumbers.add(bonusNumber);
        
        validateNumberRange(allNumbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBERS_SIZE);
        }
    }

    private void validDuplicateNumber(List<Integer> numbers) {

        Set<Integer> notDuplicateNumbers = new HashSet<>(numbers);

        if (notDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBERS);
        }
    }

    private void validateBonusNumberInNumbers(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_IN_WINNER_NUMBERS);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
                throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE);
            }
        }
    }
}
