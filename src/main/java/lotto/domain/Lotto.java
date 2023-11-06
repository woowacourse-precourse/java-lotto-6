package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public static final int LOTTO_PRICE =1000;
    public static final int LOTTO_MIN_NUMBER=1;
    public static final int LOTTO_MAX_NUMBER=45;
    public static  final int LOTTO_SIZE=6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateChecker(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicateChecker(List<Integer> numbers) {
        List<Integer> checkedList = new ArrayList<>();
        for (int i = 0; i < LOTTO_SIZE; i++) {
            if (checkedList.contains(numbers.get(i))) {
                throw new IllegalArgumentException();
            } else {
                checkedList.add(numbers.get(i));
            }
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
