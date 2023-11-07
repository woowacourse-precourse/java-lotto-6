package lotto;

import java.util.ArrayList;
import java.util.List;

public record LottoDto(List<Integer> numbers) {

    public static LottoDto from(final Lotto lotto) {
        return new LottoDto(lotto.numbers());
    }

    @Override
    public List<Integer> numbers() {
        return new ArrayList<>(numbers);
    }
}
