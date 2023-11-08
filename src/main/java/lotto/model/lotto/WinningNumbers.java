package lotto.model.lotto;

import static lotto.util.message.ErrorMessages.BONUS_DUPLICATION_EXCEPTION;

public class WinningNumbers {
    private final Lotto lotto;
    private final Bonus bonus;

    public WinningNumbers(Lotto lotto, Bonus bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public int getMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
            .filter(this::isContain)
            .count();
    }

    public Bonus getBonus() {
        return bonus;
    }

    private void validate(Lotto lotto, Bonus bonus) {
        if (isContain(lotto, bonus)) {
            throw new IllegalArgumentException(BONUS_DUPLICATION_EXCEPTION);
        }
    }

    private boolean isContain(Integer number) {
        return this.lotto.isContain(number);
    }

    private boolean isContain(Lotto lotto, Bonus bonus) {
        return lotto.isContain(bonus.getNumber());
    }
}
