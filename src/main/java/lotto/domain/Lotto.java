package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        noDuplication(numbers);
        rangeExceptionHandling(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[Error] 로또 번호는 6개만 입력 해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void noDuplication(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);

        if (numSet.size() != numbers.size()) {
            System.out.println("[Error] 로또 번호는 중복된 숫자가 있으면 안 됩니다.");
            throw new IllegalArgumentException();
        }
    }

    public void rangeExceptionHandling(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }
}
