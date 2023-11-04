package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void isDuplicate(List<Integer> numbers) {
        HashSet<Integer> temp = new HashSet<>(numbers);
        if (temp.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복됩니다.");
        }
    }
}
