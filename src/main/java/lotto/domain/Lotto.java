package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.service.NumberValidator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumbersInRange(numbers);
        validateNumbersIsDuplicated(numbers);
        this.numbers = numbers;
    }


    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LottoNumbers.LOTTO_SIZE.getNumber()) {
            throw new IllegalArgumentException("[ERROR] 6개의 로또 번호만 입력할 수 있습니다.");
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        NumberValidator numberValidator = new NumberValidator();
        for (int number : numbers) {
            numberValidator.validateNumberInRange(number);
        }
    }

    private void validateNumbersIsDuplicated(List<Integer> numbers) {
        Set<Integer> copyNumbers = new HashSet<>(numbers);
        if (copyNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복되었습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
