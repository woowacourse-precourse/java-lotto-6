package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int LOTTO_SIZE = 6;

    private List<Integer> generateLottoNumbers() {
        return sortLottoNumbers(Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, LOTTO_SIZE));
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
