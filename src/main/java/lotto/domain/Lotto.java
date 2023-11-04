package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Config;

public class Lotto {

    private static final int LOTTO_LENGTH = Config.LOTTO_LENGTH;
    private static final int MIN_VALUE = Config.MIN_VALUE;
    private static final int MAX_VALUE = Config.MAX_VALUE;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
    }


    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        List<Integer> checker = new ArrayList<>();
        for (int number : numbers) {
            if (checker.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 숫자는 중복될 수 없습니다.");
            }
            checker.add(number);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_VALUE || number > MAX_VALUE) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 범위의 숫자만 가능합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    public String toString() {
        StringBuilder string = new StringBuilder("[" + numbers.get(0));
        for (int number : numbers.subList(1, numbers.size())) {
            string.append(", ");
            string.append(number);
        }
        string.append("]");

        return String.valueOf(string);
    }
}