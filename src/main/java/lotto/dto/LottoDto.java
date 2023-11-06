package lotto.dto;

import lotto.model.Lotto;

public class LottoDto {
    private final String numbers;

    private LottoDto(Lotto lotto) {
        numbers = lotto.toString();
    }

    public static LottoDto from(Lotto lotto) {
        return new LottoDto(lotto);
    }

    @Override
    public String toString() {
        return numbers;
    }
}
