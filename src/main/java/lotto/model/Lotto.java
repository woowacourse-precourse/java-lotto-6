package lotto.model;

import java.util.Collections;
import java.util.List;
import lotto.view.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDistinctNumbers(numbers);
        validateNumbersRange(numbers);
    }

    public void validateBonusNumber(BonusNumber bonusNumber) {
        if(numbers.contains(bonusNumber.getValue())) {
            ErrorMessage.printBonusNumberDistinctError();
            throw new IllegalArgumentException();
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ErrorMessage.printLottoNumbersSizeError();
            throw new IllegalArgumentException();
        }
    }

    private void validateDistinctNumbers(List<Integer> numbers) {
        if(numbers.size() != numbers.stream()
                .distinct()
                .count()) {
            ErrorMessage.printLottoDistinctNumberError();
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        if(numbers.stream()
                .anyMatch(number -> number < 1 || number > 45)) {
            ErrorMessage.printLottoNumberRangeError();
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
