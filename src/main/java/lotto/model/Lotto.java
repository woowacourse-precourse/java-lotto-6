package lotto.model;

import lotto.record.LottoNumberRecord;

public class Lotto {
    private final LottoNumbers numbers; // TODO : NumbersList 일급 컬렉션 구현

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
