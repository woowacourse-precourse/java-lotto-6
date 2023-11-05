package lotto.model.domain;


import lotto.model.domain.exception.LottoException;

public class WinningNumbers {
    private final Lotto lotto;
    private final int bonus;

    public WinningNumbers(Lotto lotto, int bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(Lotto lotto, int bonus) {
        if (lotto.getNumbers().contains(bonus)) {
            LottoException.duplicateException();
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }
}
