package model;

import enums.ErrorMessageEnums;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() != 6) {
            throw new IllegalArgumentException(ErrorMessageEnums.TOO_MANY_NUMBERS.toString());
        }
        numbers.forEach(this::checkRange);
    }

    private void checkRange(Integer i) {
        if (i > 45 || i < 1) {
            throw new IllegalArgumentException(ErrorMessageEnums.OUT_OF_RANGE.toString());
        }
    }

    public Integer compareNumbers(List<Integer> bullseye) {
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

    @Override
    public String toString() {
        return numbers.toString();
    }
}
