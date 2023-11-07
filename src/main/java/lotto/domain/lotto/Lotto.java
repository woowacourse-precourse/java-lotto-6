package lotto.domain.lotto;

import java.util.List;

public class Lotto {
    private final LottoNumbers numbers;

    public Lotto(final LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public int countMatch(final LottoNumbers other) {
        return numbers.countMatch(other);
    }

    public boolean checkBonusNumber(final LottoNumber bonusNumber) {
        return numbers.checkBonusNumber(bonusNumber);
    }

    public List<Integer> getLottoInfo() {
        return numbers.numbers().stream()
                .map(LottoNumber::number)
                .toList();
    }
}
