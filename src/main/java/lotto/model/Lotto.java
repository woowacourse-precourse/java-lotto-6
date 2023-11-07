package lotto.model;

import lotto.model.number.LottoNumbers;

public class Lotto {
    private final LottoNumbers numbers;

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public LottoNumbers getLottoNumbers() {
        return numbers;
    }

    public LottoNumbers getSortedLottoNumbers() {
        return new LottoNumbers(numbers.getSortedNumbers());
    }
}
