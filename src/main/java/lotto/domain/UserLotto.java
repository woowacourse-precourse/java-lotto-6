package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLotto {
    private static final int START_NUM = 1;
    private static final int END_NUM = 45;
    private static final int GENERATE_NUM = 6;

    private List<Integer> numbers;

    public void setLotto() {
        numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, GENERATE_NUM));
        Collections.sort(numbers);
    }

    public List<Integer> getLotto() {
        return numbers;
    }
}
