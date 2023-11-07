package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.Lotto;

public class RandomNumbers {
    public List<Integer> draw() {
        return randomNumberPick();
    }

    public List<Integer> randomNumberPick() {

        return Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.LOTTO_NUMBER_COUNT);
    }
}
