package lotto.dto;

import java.util.List;

public record LottoDto(List<Integer> numbers) {

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .toList()
                .toString();
    }
}
