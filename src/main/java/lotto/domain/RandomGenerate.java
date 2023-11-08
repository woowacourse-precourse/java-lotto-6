package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomGenerate {
    public List<Integer> createNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> orderNumbers = new ArrayList<>(numbers);
        Collections.sort(orderNumbers);
        return orderNumbers;
    }
}
