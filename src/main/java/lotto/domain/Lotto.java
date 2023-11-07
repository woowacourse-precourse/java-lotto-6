package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.error.Error;
import lotto.error.Error.ErrorType;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> setNumbers = new HashSet<>(numbers);
        boolean duplication = setNumbers.size() != numbers.size();

        if (numbers.size() != 6) {
            Error.errorMessage(ErrorType.INVALID_LOTTO_INPUT);
        } else if (duplication) {
            Error.errorMessage(ErrorType.DUPLICATION);
        }
    }

    // TODO: 추가 기능 구현
    public void inputBonusNumber(int bonusNumber) {
        this.numbers.add(bonusNumber);
    }
}
