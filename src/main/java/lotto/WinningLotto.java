package lotto;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonus;

    private WinningLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static WinningLotto of(List<Integer> winningNumbers, int bonus) {
        Lotto winningLotto = new Lotto(winningNumbers);
        validateBonus(winningLotto, bonus);

        return new WinningLotto(winningLotto, bonus);
    }

    private static void validateBonus(Lotto lotto, int bonus) {
        if (bonus<1||bonus>45) {
            throw new IllegalArgumentException();
        }
        if (!lotto.hasNumber(bonus)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers().stream().sorted().toList();
    }

    public int getBonus() {
        return bonus;
    }
}