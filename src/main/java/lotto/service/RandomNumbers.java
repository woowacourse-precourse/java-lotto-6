package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbers {
    public List<Integer> draw() {
        return randomNumberPick();
    }

    public List<Integer> randomNumberPick() {

        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
