package lotto.model;

import java.util.HashSet;
import java.util.Set;

public class LottoAnswer {

    private final Lotto answer;
    private final BonusNumber bonusNumber;

    public LottoAnswer(Lotto answer, BonusNumber bonusNumber) {
        this.answer = answer;
        this.bonusNumber = bonusNumber;
    }

    public Rank getRankOf(Lotto lotto) {
        Set<Integer> answerSet = answer.toSet();
        Set<Integer> lottoSet = lotto.toSet();

        Set<Integer> remain = new HashSet<>(answerSet);
        remain.removeAll(lottoSet);

        if (remain.size() == 0) {
            return Rank.FIRST;
        }
        if (remain.size() == 1) {
            if (lottoSet.contains(bonusNumber.number())) {
                return Rank.SECOND;
            }
            return Rank.THIRD;
        }
        if (remain.size() == 2) {
            return Rank.FOURTH;
        }
        if (remain.size() == 3) {
            return Rank.FIFTH;
        }

        return Rank.NONE;
    }
}
