package lotto.dto;

import java.util.Arrays;
import java.util.List;

public record LottoDto(
        List<Integer> numbers
) {
    public String getLottoNumbers() {
        return Arrays.toString(numbers.toArray());
    }
}
