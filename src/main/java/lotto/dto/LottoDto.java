package lotto.dto;

import lotto.model.Lotto;

import java.util.List;

public class LottoDto {
    private final List<Integer> numbers;

    private LottoDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoDto from(Lotto lotto) {
        return new LottoDto(lotto.getNumbers());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
