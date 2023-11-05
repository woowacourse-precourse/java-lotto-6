package lotto;

import java.util.Comparator;
import java.util.List;

public class LottoDTO {

    public static LottoDTO from(Lotto lotto) {
        return new LottoDTO(lotto.getNumbers());
    }

    private LottoDTO(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}