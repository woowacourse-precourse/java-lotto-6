package lotto;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonus;

    private WinningLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static WinningLotto of(Lotto winningNumbers, int bonus) {
        validateBonus(winningNumbers, bonus);

        return new WinningLotto(winningNumbers, bonus);
    }

    private static void validateBonus(Lotto lotto, int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력하세요.");
        }
        if (lotto.hasNumber(bonus)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.");
        }
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers().stream().sorted().toList();
    }

    public int getBonus() {
        return bonus;
    }
}