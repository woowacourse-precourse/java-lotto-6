package lotto.controller.dto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;

public class LottoDto {

    private final List<Integer> numbers;

    private LottoDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoDto from(Lotto lotto) {
        return new LottoDto(new ArrayList<>(lotto.getNumbers()));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
