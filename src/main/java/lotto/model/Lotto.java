package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean contains(Integer number) {
        return this.numbers.contains(number);
    }

    public Integer compare(Lotto other) {
        Integer count = 0;
        for (Integer number:other.numbers) {
            if (this.contains(number)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .toList()
                .toString();
    }

    private void validate(List<Integer> numbers) {
        if (notSixNumbers(numbers)) {
            throw new IllegalArgumentException();
        }

        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean notSixNumbers(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private boolean hasDuplicateNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number:numbers) {
            if (!set.add(number)) {
                return true;
            }
        }
        return false;
    }
}
