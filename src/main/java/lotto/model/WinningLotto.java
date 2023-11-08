package lotto.model;

import lotto.constant.ErrorMessage;

public class WinningLotto {

    private final Lotto lotto;
    private final Bonus bonus;

    public WinningLotto(Lotto lotto, Bonus bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(Lotto lotto, Bonus bonus) {
        if (bonus.hasBonusNumber(lotto)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE.getMessage());
        }
    }

    public Rank getRank(Lotto boughtLotto) {
        return Rank.from(lotto.count(boughtLotto), bonus.hasBonusNumber(boughtLotto));
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "lotto=" + lotto.toString() +
                ", " + bonus.toString() +
                "}";
    }
}
