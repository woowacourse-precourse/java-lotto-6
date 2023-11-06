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
        List<Integer> numbers = createRandomNumbersInRange(
                Constants.LOTTO_MIN_NUMBER, Constants.LOTTO_MAX_NUMBER, Constants.LOTTO_NUMBER_COUNTS);
        sortNumbers(numbers);
        return numbers;
    }

    private List<Integer> createRandomNumbersInRange(int min, int max, int count) {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(min, max, count));
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}