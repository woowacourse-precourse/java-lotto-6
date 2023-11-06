package lotto.util;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberUtil {
    
    public List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
