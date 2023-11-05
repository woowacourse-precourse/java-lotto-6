package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {

    public NumberGenerator() {
        createRandomLottoNumbers();
    }

    public List<Integer> createRandomLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers; // ex. [1,2,10,15,20,45]
    }
}
