package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Computer {

    private Lotto lotto;
    private Bonus bonus;

    public void drawRandomNumber(int money) {
        for (int drawLotto = 0; drawLotto < money / 1000; drawLotto++) {
            lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            bonus = new Bonus(lotto);
        }
    }
}
