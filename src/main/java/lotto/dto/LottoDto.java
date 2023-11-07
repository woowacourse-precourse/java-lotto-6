package lotto.dto;

import java.util.List;

import lotto.model.Lotto;

public record LottoDto(
        List<Integer> numbers
) {
    public static LottoDto from(final Lotto lotto) {
        return new LottoDto(lotto.getNumbers());
    }
}
