package lotto.dto;

import java.util.Arrays;
import java.util.List;

public record LottoDto(
        List<Integer> numbers
) {
    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }
}
