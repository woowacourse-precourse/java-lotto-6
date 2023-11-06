package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private Lotto lotto;

    public List<Lotto> drawRandomNumber(int money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int drawAttempt = 0;  drawAttempt < money / 1000; drawAttempt++) {
            lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto.getPuschaseLotto());
        }
        return lottos;
    }
}
