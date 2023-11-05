package lotto;

import java.util.List;

public class Referee {
    public void compare(List<Lotto> lottos, Lotto winningLotto, int bonus) {
        Judgment judgment = new Judgment();

        for (Lotto lotto : lottos) {
            int correctCount = judgment.correctCount(lotto.getNumbers(), winningLotto.getNumbers());
            boolean hasBonus = judgment.hasBonus(lotto.getNumbers(), bonus);
        }
    }
}
