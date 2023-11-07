package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.util.ErrorMessages;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.NOT_SIX_NUMBER_ERROR.getMessage());
        }

        if (isNumbersInSameNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NUMBER_ERROR.getMessage());
        }

        if (isOverOrUnderRangeNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessages.OVER_OR_UNDER_NUMBER_RANGE_ERROR.getMessage());
        }
    }

    private boolean isOverOrUnderRangeNumber(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num < 0 || num > 45)
                .count() != 0;
    }

    private boolean isNumbersInSameNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return numbers.size() != set.size();
    }

    // TODO: 추가 기능 구현
    public int calculateMatchCount(Lotto issuedLotto) {
        List<Integer> issuedLottoNumbers = issuedLotto.numbers;
        return (int) numbers.stream()
                .filter(num -> issuedLottoNumbers.contains(num))
                .count();
    }

    public boolean checkContainBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
