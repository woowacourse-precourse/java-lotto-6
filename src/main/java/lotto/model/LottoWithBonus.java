package lotto.model;

import java.util.Objects;

public class LottoWithBonus {
    private final Lotto lotto;
    private final Integer bonus;

    public LottoWithBonus(Lotto lotto, Integer bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public boolean bonusMatches(Integer number) {
        return bonus.equals(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        LottoWithBonus another = (LottoWithBonus) o;
        return this.bonus.equals(another.bonus) &&
                this.lotto.equals(another.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonus, lotto);
    }
}
