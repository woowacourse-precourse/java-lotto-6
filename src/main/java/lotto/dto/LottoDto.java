package lotto.dto;

import lotto.domain.Lotto;
import java.util.List;

public record LottoDto(List<Integer> numbers) {
    public static LottoDto of(Lotto lotto) {
        return new LottoDto(lotto.getNumbers());
    }
}