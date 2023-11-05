package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicatedNumber(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] 6자리 숫자를 입력해 주세요.");
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 6자리 숫자를 입력해 주세요.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 각 번호는 1 이상 45 이하로 입력해 주세요.");
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}