package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class UserLotto {
    public UserLotto() {

    }
    private static final int CNT = 6;
    private static final int MIN = 1;
    private static final int MAX = 45;

    public List<Integer> getNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN, MAX, CNT);
        Collections.sort(numbers);
        return numbers;
    }
}
