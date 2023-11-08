package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.utils.phrase.ErrorPhrase.*;
import static lotto.utils.system.LottoSystemUtils.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = sortedNumbers(numbers);
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public boolean contain(Integer num) {
        return numbers.contains(num);
    }

    public int matchCount(Lotto myLotto) {
        return (int) numbers.stream()
                .filter(myLotto::contain)
                .count();
    }

    private List<Integer> sortedNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        isRightLottoCnt(numbers);
        isNotDuplicate(numbers);
        isRightLottoRange(numbers);
    }

    private void isRightLottoCnt(List<Integer> numbers) {
        if (numbers.size() != LOTTO_CNT) {
            throw new IllegalArgumentException(ERROR_PHRASE_INPUT_RIGHT_LOTTO_CNT);
        }
    }

    private void isNotDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();

        for (Integer num : numbers) {
            if (set.contains(num)) {
                throw new IllegalArgumentException(ERROR_PHRASE_LOTTO_NUMBER_IS_DUPLICATED);
            }
            set.add(num);
        }
    }

    private void isRightLottoRange(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (num < LOTTO_NUMBER_MIN_RANGE || num > LOTTO_NUMBER_MAX_RANGE) {
                throw new IllegalArgumentException(ERROR_PHRASE_LOTTO_NUMBER_IS_OUT_OF_RANGE);
            }
        }
    }
}
