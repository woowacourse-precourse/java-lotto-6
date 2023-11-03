package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        exceed(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자여야 합니다.");
        }
    }

    private void duplicate(List<Integer> numbers) {
        Set<Integer> check_duplicate = new HashSet<>();

        for (Integer number : numbers) {
            if (check_duplicate.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복된 숫자가 아니어야 합니다.");
            }
            check_duplicate.add(number);
        }
    }

    private void exceed(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호의 입력 가능 범위는 1부터 45까지 입니다.");
            }
        }
    }
}
