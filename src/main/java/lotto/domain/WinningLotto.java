package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto answerLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto answerLotto, BonusNumber bonusNumber) {
        this.answerLotto = answerLotto;
        this.bonusNumber = bonusNumber;
    }

    public int calculateMathCount(List<Integer> lotto) {
        int count = 0;
        for (Integer number : lotto) {
            if(answerLotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public int getBonusNumber() {
        return bonusNumber.value();
    }
}
