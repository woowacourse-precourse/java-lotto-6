package lotto.domain;

import java.util.List;

import static lotto.constants.ErrorMessageConstants.*;
import static lotto.constants.LottoConstants.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현
    public int checkMatchingNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream().filter(number -> winningNumbers.contains(number)).count();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_SIZE);
        }

        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBERS);
        }
    }
    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }
}
