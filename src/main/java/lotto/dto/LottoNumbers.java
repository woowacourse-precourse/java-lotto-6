package lotto.dto;

import java.util.List;

public record LottoNumbers(List<Integer> numbers) {

    public String displayNumbers() {
        List<String> sortedNumbers = numbers.stream()
                .sorted()
                .map(String::valueOf)
                .toList();
        return "[" + String.join(", ", sortedNumbers) + "]";
    }
}
