package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private Lotto lotto;

    public void drawRandomNumber(int money) {
        for (int drawLotto = 0; drawLotto < money / 1000; drawLotto++) {
            lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }
}
