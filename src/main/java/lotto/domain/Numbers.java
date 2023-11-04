package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = createNumbersList(numbers);
    }

    public static List<Number> createNumbersList(List<Integer> integerList) {
        return integerList.stream()
            .map(Number::new)
            .collect(Collectors.toList());
    }
}
