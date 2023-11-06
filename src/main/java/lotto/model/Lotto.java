package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 쉼표와 함께 입력해주세요.");
        } else if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        } else if (!numbers.stream().allMatch(n -> n >= 1 && n <= 45)) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 까지의 숫자를 입력해주세요.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }


}
