package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateChecker(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicateChecker(List<Integer> numbers){
        List<Integer> checkedList = new ArrayList<>();
        for (int i = 0; i<numbers.size(); i++) {
            if (checkedList.contains(numbers.get(i))) {
                checkedList.add(numbers.get(i));
            } else {
                throw new IllegalArgumentException();
            };
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
