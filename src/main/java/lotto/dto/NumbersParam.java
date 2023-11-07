package lotto.dto;

import java.util.List;

public record NumbersParam(List<String> numbers) {
    public static NumbersParam from(final List<Integer> numbers) {
        List<String> responseNumbers = numbers.stream()
                .sorted()
                .map(String::valueOf)
                .toList();
        return new NumbersParam(responseNumbers);
    }
}
