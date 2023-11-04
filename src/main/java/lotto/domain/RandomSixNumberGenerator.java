package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomSixNumberGenerator {
    public List<Integer> getSixNumber() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));

        return getSortedList(numbers);
    }

    private List<Integer> getSortedList(List<Integer> numbers) {
        Collections.sort(numbers);

        return numbers;
    }
}