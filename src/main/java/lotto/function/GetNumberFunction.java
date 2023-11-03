package lotto.function;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GetNumberFunction {
    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }
}
