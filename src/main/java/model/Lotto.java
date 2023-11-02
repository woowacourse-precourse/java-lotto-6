package model;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public Integer checkNumbers(List<Integer> bullseye) {
        Integer count = 0;
        for (Integer i : bullseye) {
            if (numbers.contains(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean checkBonus(Integer bonus) {
        return numbers.contains(bonus);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
