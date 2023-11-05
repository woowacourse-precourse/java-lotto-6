package lotto.domain;

import lotto.utils.StringUtils;

import java.util.List;
import java.util.Objects;

public class Paper {
    private final Lotto lotto;
    private final Bonus bonus;

    private Paper(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static Paper of(String lotto, String bonus) {
        List<Integer> numbers = StringUtils.toIntegerList(lotto);
        int newBonus = StringUtils.toInt(bonus);
        Lotto newLotto = Lotto.of(numbers);
        return new Paper(newLotto, Bonus.ofAndCheckDuplicatedNumber(newLotto, newBonus));
    }

    public Lotto getLotto() {
        return lotto;
    }


    public int matchingLotto(Lotto lotto, boolean isBonus) {
        if (isBonus) {
            return this.lotto.matchingLotto(lotto) + matchingBonus(lotto);
        }
        return this.lotto.matchingLotto(lotto);
    }

    private int matchingBonus(Lotto lotto) {
        return bonus.matchingNumber(lotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paper paper = (Paper) o;
        return Objects.equals(lotto, paper.lotto) && Objects.equals(bonus, paper.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonus);
    }
}
