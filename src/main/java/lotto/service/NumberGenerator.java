package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class NumberGenerator {
    public List<Integer> creatRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return numbers;
    }
}
