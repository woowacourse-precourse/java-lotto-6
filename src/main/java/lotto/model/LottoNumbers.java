package lotto.model;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    private final List<Lotto> numbers;

    private LottoNumbers(List<Lotto> numbers) {
        this.numbers = numbers;
    }

    public static LottoNumbers createLottoNumbers(List<Lotto> numbers) {
        return new LottoNumbers(numbers);
    }

    public List<Lotto> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
