package lotto.model;

import lotto.record.LottoNumberRecord;
import lotto.record.LottoNumbers;

public class Lotto {
    private final LottoNumbers numbers;

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public LottoNumberRecord toRecord() {
        return new LottoNumberRecord(numbers.lottoNumbers());
    }

    public String makeLottoNumberString() {
        return numbers
                .lottoNumbers().stream()
                .sorted()
                .toList()
                .toString();
    }

}
