package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.constant.Exception;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final static int MIN_RANGE = 1;
    private final static int MAX_RANGE = 45;
    private final static int COUNT = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException(Exception.LOTTO_SIZE);
        }
        List<Integer> lotto = numbers.stream().distinct().toList();
        if (lotto.size() != COUNT) {
            throw new IllegalArgumentException(Exception.LOTTO_DUPLICATED);
        }
        if (getSizeInRange(lotto) != COUNT) {
            throw new IllegalArgumentException(Exception.LOTTO_RANGE);
        }
    }

    private int getSizeInRange(List<Integer> lotto) {
        return lotto.stream()
                .filter(integer -> integer >= MIN_RANGE && integer <= MAX_RANGE)
                .toList().size();
    }

    public static List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, COUNT);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
