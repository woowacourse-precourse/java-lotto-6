package lotto.model;

import java.util.List;
import lotto.constant.LottoRanking;

public class LottoChecker {

    private Lotto winningLotto;
    private int bonusNumber;

    public LottoChecker(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRanking check(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        boolean bonus = numbers.contains(bonusNumber);

        numbers.retainAll(winningLotto.getNumbers());
        return LottoRanking.of(numbers.size(), bonus);
    }
}
