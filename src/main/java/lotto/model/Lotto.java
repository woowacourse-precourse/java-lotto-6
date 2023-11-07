package lotto.model;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public void checkPrize(Integer bonusNumber, List<List<Integer>> lottoNumber) {
        for (List<Integer> integers : lottoNumber) {
            List<Integer> ResultList = integers.stream()
                    .filter(i -> this.numbers.stream().anyMatch(Predicate.isEqual(i)))
                    .collect(Collectors.toList());
            System.out.println(ResultList);
        }
    }
}