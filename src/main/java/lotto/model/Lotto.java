package lotto.model;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        isNumberInRangeForMultipleNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 6개의 숫자가 아닙니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복되는 숫자가 있습니다.");
        }
    }

    private void isNumberInRangeForMultipleNumber(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            isNumberInRange(numbers.get(i));
        }
    }

    private void isNumberInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1과 45사이의 숫자가 아닙니다.");
        }
    }


    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
