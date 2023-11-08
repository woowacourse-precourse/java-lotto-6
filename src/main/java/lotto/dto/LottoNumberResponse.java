package lotto.dto;

import lotto.domain.lottery.Lotto;

import java.util.List;

public record LottoNumberResponse(
        List<Integer> numbers
) {
    public static LottoNumberResponse build(final Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        return new LottoNumberResponse(numbers);
    }
}
