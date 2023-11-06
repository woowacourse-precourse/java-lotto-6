package lotto.model;

import java.util.List;
import lotto.model.number.LottoNumber;
import lotto.model.number.LottoNumbers;

public class Lotto {
    private final LottoNumbers numbers;

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public LottoNumbers getNumbers() {
        return numbers;
    }

    public LottoNumbers getSortedNumbers() {
        return new LottoNumbers(numbers.getSortedNumbers());
    }
}
