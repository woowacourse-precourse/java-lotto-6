package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.message.ExceptionMessage;
import lotto.common.utils.NumberUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto generate() {
        List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(NumberUtil.MIN_RANGE, NumberUtil.MAX_RANGE, NumberUtil.LOTTO_COUNT));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.OVER_SIZE);
        }
        if (new HashSet<>(numbers).size() != NumberUtil.LOTTO_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER);
        }

        numbers.stream()
                .filter(number -> number < NumberUtil.MIN_RANGE || number > NumberUtil.MAX_RANGE)
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException(ExceptionMessage.OVER_RANGE);
                });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}