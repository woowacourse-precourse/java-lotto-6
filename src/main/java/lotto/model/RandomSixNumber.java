package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;


public class RandomSixNumber {
    public List<Integer> generate() {
        List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(randomNumber);
        return randomNumber;
    }
}
