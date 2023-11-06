package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.utils.Constants;

public class NumberGenerator {
    public NumberGenerator() {
    }

    public List<Integer> createRandomLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                Constants.LOTTO_MIN_NUMBER, Constants.LOTTO_MAX_NUMBER, Constants.LOTTO_NUMBER_COUNTS));
        Collections.sort(numbers);
        return numbers;
    }
}
