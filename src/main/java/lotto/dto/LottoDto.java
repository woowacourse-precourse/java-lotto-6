package lotto.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;

public class LottoDto {

    private final List<Integer> numbers;

    private LottoDto(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static List<LottoDto> toDto(final List<Lotto> lotteries) {
        return lotteries.stream()
                .map(LottoDto::from)
                .toList();
    }

    private static LottoDto from(final Lotto lotto) {
        List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
        Collections.sort(numbers);
        return new LottoDto(Collections.unmodifiableList(numbers));
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
