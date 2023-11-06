package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.common.util.LottoUtil;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        limit(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoUtil.SIZE.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicate(List<Integer> numbers) {
        List<Integer> duplicates = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > LottoUtil.DUPLICATE.getNumber())
                .map(Map.Entry::getKey)
                .toList();

        if (!duplicates.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void limit(List<Integer> numbers) {
        List<Integer> outOfRangeNumbers = numbers.stream()
                .filter(number -> number < LottoUtil.MIN.getNumber() || number > LottoUtil.MAX.getNumber())
                .toList();

        if (!outOfRangeNumbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
