package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> mutableNumbers = new ArrayList<>(numbers);
        Collections.sort(mutableNumbers);
        this.numbers = mutableNumbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> validationDuplicate = new HashSet<>(numbers);
        if (numbers.size() != validationDuplicate.size()) {
            throw new IllegalArgumentException("");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int compare(List<Integer> winingLotto) {
        int count = 0;
        for (Integer winingNumber : winingLotto) {
            if (numbers.contains(winingNumber)) {
                count++;
            }
        }
        return count;
    }

    public boolean containBonus(int bonus) {
        return numbers.contains(bonus);
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
