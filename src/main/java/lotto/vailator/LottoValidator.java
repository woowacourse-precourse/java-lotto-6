package lotto.vailator;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static lotto.util.ErrorMessage.*;
import static lotto.util.LottoNumber.*;

public class LottoValidator {
    private boolean isNotSizeSix(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE.getValue();
    }

    public void checkSize(List<Integer> numbers) {
        if (isNotSizeSix(numbers)) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR.getErrorMessage());
        }
    }

    private boolean isNotInRange(List<Integer> numbers) {
        Optional<Integer> notRangeNum = numbers.stream()
                .filter(number -> START_LOTTO_NUMBER.getValue() > number || number > END_LOTTO_NUMBER.getValue())
                .findAny();

        if (notRangeNum.isPresent()) {
            return true;
        }
        return false;
    }

    public void checkRange(List<Integer> numbers) {
        if (isNotInRange(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR.getErrorMessage());
        }
    }

    private boolean isDuplicateWinningNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return numbers.size() != uniqueNumbers.size();
    }

    public void checkDuplicateWinningNumbers(List<Integer> numbers) {
        if (isDuplicateWinningNumbers(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_IN_WINNING_LOTTO.getErrorMessage());
        }
    }
}
