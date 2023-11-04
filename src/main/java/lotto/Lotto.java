package lotto;

import java.util.Collections;
import java.util.List;

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

        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int getCountingMatchingNumbers(Lotto lotto) {
        int count =0;
        for(int i=0; i<numbers.size(); i++) {
            if(containsNumber(lotto.getNumbers().get(i))) {
                count++;
            }
        }
        return count;
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }
}
