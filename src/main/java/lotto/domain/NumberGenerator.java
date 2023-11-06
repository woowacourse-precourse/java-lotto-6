package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.utils.Constants;

public class NumberGenerator {
    public NumberGenerator() {
    }

    public List<Integer> createRandomLottoNumbers() {
        List<Integer> numbers = generateUniqueRandomNumbers();
        sortNumbers(numbers);
        return numbers;
    }

    private List<Integer> generateUniqueRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                Constants.LOTTO_MIN_NUMBER, Constants.LOTTO_MAX_NUMBER, Constants.LOTTO_NUMBER_COUNTS);
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
