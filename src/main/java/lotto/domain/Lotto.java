package lotto.domain;

import lotto.view.ExceptionMessage;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.view.ExceptionMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLottoNumbersDuplication(numbers);
        validateLottoNumberRange(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(SIZE_EXCEPTION.getMessage());
        }
    }

    // TODO: 추가 기능 구현

    private void validateLottoNumbersDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(OVERLAP_EXCEPTION.getMessage());
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        numbers.forEach(item -> {
            if (item < 1 || item > 45) {
                throw new IllegalArgumentException(RANGE_EXCEPTION.getMessage());
            }
        });
    }

    public void duplictionLottoBonusNumberAndWinNumber(Integer lottoBonusNumber) {
        if (numbers.contains(lottoBonusNumber)) {
            throw new IllegalArgumentException(OVERLAP_EXCEPTION.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
