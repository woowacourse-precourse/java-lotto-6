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
            throw new IllegalArgumentException();
        }
    }

    public int compare(int[] array) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : numbers) {
            set1.add(num);
        }
        for (int num : array) {
            set2.add(num);
        }
        set1.retainAll(set2);
        return set1.size();
    }

    public int bonus_compare(int a) {

        for (int i = 0; i < 6; i++) {
            if (this.numbers.get(i) == a) {
                return 1;
            }
        }
        return 0;
    }

    // TODO: 추가 기능 구현
}
