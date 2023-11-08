package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final int LOTTO_CNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isNotDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void isNotDuplicate(List<Integer> numbers){
        Set<Integer> set = new HashSet<>();

        set.addAll(numbers);

        if(set.size() != LOTTO_CNT)
            throw new IllegalArgumentException();
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
