package lotto.dto;

import java.util.List;

public record LottoResponse(
        List<Integer> numbers
) {
    public List<Integer> getResponse() {
        return numbers.stream()
                .sorted()
                .toList();
    }
}
