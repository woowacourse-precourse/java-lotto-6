package lotto.domain;

import static lotto.constants.Rank.FIFTH;
import static lotto.constants.Rank.FIRST;
import static lotto.constants.Rank.FOURTH;
import static lotto.constants.Rank.SECOND;
import static lotto.constants.Rank.THIRD;

import lotto.constants.Rank;

public class Judge {
    public Rank selectRank(int sameNumber, Lotto numbers, int bonusNumber) {
        if (sameNumber == 6) {
            return FIRST;
        }
        if (sameNumber == 5 && Comparator.checkBonusNumber(numbers, bonusNumber)) {
            return SECOND;
        }
        if (sameNumber == 5 && !Comparator.checkBonusNumber(numbers, bonusNumber)) {
            return THIRD;
        }
        if (sameNumber == 4) {
            return FOURTH;
        }
        if (sameNumber == 3) {
            return FIFTH;
        }
        return null;
    }
}
