package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Win {
    private Lotto winningLotto;
    private int bonus;

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public void setWinningLotto(String winningNumbers) {
        this.winningLotto = new Lotto(StringtoList(winningNumbers));
    }

    private List<Integer> StringtoList(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
