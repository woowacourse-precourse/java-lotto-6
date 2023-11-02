package lotto;

import java.util.Collections;
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
            throw new IllegalArgumentException("[ERROR] 숫자 6개를 입력해 주세요.");
        }
        if (Collections.max(numbers) > 45 || Collections.min(numbers) < 1) {
            throw new IllegalArgumentException("[ERROR] 1과 45사이의 숫자만 입력해 주세요.");
        }
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복 되지 않도록 입력해 주세요.");
        }
    }

    // TODO: 추가 기능 구현
}
