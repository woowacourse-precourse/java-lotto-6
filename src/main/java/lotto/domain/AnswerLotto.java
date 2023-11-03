package lotto.domain;

import java.util.List;

public class AnswerLotto {

    private final Lotto winnginLotto;
    private final BonusNumber bonusNumber;

    public AnswerLotto(Lotto winnginLotto, BonusNumber bonusNumber) {
        this.winnginLotto = winnginLotto;
        this.bonusNumber = bonusNumber;
    }

    public int getMatchCount(List<Integer> lotto) {
        int count = 0;
        for (Integer number : lotto) {
            if(winnginLotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public int getBonusNumber() {
        return bonusNumber.value();
    }
}
