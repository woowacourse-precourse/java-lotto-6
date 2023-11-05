package lotto.model;

import lotto.record.LottoNumberRecord;

public class Lotto {
    private final LottoNumbers numbers;

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public LottoNumberRecord toRecord() {
        return new LottoNumberRecord(numbers.getLottoNumbers());
    }

    public String makeLottoNumberString() {
        return numbers
                .getLottoNumbers().stream()
                .sorted()
                .toList()
                .toString();
    }

}
