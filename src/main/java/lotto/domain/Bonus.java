package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Bonus {

    private int bonus;

    public Bonus(Lotto lotto) {
        this.bonus = drawBonusNumber(lotto);
    }

    public int getBonus() {
        return bonus;
    }

    private int drawBonusNumber(Lotto lotto) {
        while (true) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int number = Randoms.pickUniqueNumbersInRange(1, 45, 1).get(0);
            if (!lottoNumbers.contains(number)) {
                return number;
            }
        }
    }
}
