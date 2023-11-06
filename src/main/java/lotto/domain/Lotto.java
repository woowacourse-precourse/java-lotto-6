package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int SUM_SIZE = 12;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        HashSet<Integer> nonDuplicate = new HashSet<>(numbers);
        if (nonDuplicate.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public String toString() {
        return numbers.toString();
    }

    public int compareWithSelected(List<Integer> selectedLottos) {
        int count = 0;
        List<Integer> sum = new ArrayList<>(numbers);
        sum.addAll(selectedLottos);
        HashSet<Integer> nonDuplicate = new HashSet<>(sum);
        count = SUM_SIZE - nonDuplicate.size();

        return count;
    }
}
