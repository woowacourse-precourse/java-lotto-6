package lotto.model;

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
            throw new IllegalArgumentException();
        }
        Set<Integer> numSet = new HashSet<>(numbers);

        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 생성된 로또 번호 중 중복 된 수가 있습니다.");
        }
    }


    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

}
