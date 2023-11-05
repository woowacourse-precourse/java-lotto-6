package lotto.dto;

import lotto.domain.Lotto;

import java.util.List;

public record LottoNumberResponse(
        List<Integer> numbers
) {
    public static LottoNumberResponse buildLottoResponse(final Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        return new LottoNumberResponse(numbers);
    }
}
