package lotto.domain;

public class WinningNumbers {
    private final Lotto answerLotto;
    private final LottoNumber bonusNumber;

    public WinningNumbers(final Lotto answerLotto, final LottoNumber bonusNumber) {
        this.answerLotto = answerLotto;
        this.bonusNumber = bonusNumber;
    }
}
