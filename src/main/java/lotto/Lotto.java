package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(); // 로또 번호는 6자리여야 합니다.
        }

        for (Integer number : numbers) {
            if (!(number >= 1 && number <= 45)) {// if 입력된 숫자 1 ~ 45 사이 아닐 때 {
            throw new IllegalArgumentException(); // 로또 번호는 1부터 45 사이의 숫자여야 합니다.
            }
        }

        Set<Integer> uniqueNumber = new HashSet<>(numbers);

        if (uniqueNumber.size() != numbers.size()) {
            throw new IllegalArgumentException(); // 입력된 로또 번호에는 중복이 존재하지 않아야 합니다.
        }
    }
}
