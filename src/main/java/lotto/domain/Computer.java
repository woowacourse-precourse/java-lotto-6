package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {

    private Lotto lotto;

    public List<Lotto> drawRandomNumber(int money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int drawAttempt = 0;  drawAttempt < money / 1000; drawAttempt++) {
            List<Integer> numbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lotto = new Lotto(numbers);
            lottos.add(lotto.getPuschaseLotto());
        }
        return lottos;
    }
}
