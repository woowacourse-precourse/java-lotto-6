package lotto.domain.lotto;

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
}
