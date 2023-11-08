package lotto.dto;

import java.util.List;
import lotto.Lotto;

public record LottoDto(List<Integer> numbers) {
    public static LottoDto from(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers().stream()
                .sorted()
                .toList();

        return new LottoDto(numbers);
    }
}
