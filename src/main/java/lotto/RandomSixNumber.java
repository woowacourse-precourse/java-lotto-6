package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.sort;

public class RandomSixNumber {
    public List<Integer> Generate(){
        List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(randomNumber);
        return randomNumber;
    }
}
