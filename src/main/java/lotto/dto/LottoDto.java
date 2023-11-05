package lotto.dto;

import java.util.Collections;
import java.util.List;

public record LottoDto(List<Integer> numbers) {

    public LottoDto {
        Collections.sort(numbers);
    }
}
