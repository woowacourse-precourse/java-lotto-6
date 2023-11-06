package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Bonus {

    private int bonus;

    public Bonus(Lotto lotto) {
        this.bonus = drawBonusNumber(lotto);
    }

    public Bonus(String bonus) {
        this.bonus = changeInteger(bonus);
    }

    public int getBonus() {
        return bonus;
    }

    private int drawBonusNumber(Lotto lotto) {
        while (true) {
            List<Integer> lottoNumbers = lotto.lottoNumbers();
            int number = Randoms.pickUniqueNumbersInRange(1, 45, 1).get(0);
            if (!lottoNumbers.contains(number)) {
                return number;
            }
        }
    }

    private int changeInteger(String bonus) {
        return Integer.parseInt(bonus);
    }
}
