package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Win {
    private Lotto winningLotto;
    private int bonus;

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public void setWinningLotto(String winningLotto) {
        this.winningLotto = new Lotto(stringToList(winningLotto));
    }

    public List<Integer> stringToList(String winningLotto) {
        return Arrays.stream(winningLotto.split(","))
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
