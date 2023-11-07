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
        return (int) lotto.stream()
                .filter(answerLotto::contains)
                .count();
    }

    public int getBonusNumber() {
        return bonusNumber.value();
    }
}
