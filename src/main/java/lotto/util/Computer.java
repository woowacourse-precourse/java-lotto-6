package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Computer {
    public List<Integer> getRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
