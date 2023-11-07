package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.domain.GenerateRandomNum.pickNumber;
import static lotto.utils.Constants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        this.numbers = numbers;
    }

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(CHECK_NUMBER_SIZE);
        }
    }

    public static List<Integer> randomLottery() {
        List<Integer> lotto = Stream.generate(() -> pickNumber())
                .distinct()
                .limit(LOTTO_SIZE)
                .sorted()
                .collect(Collectors.toList());
        return lotto;
    }

    public void checkDuplicate(List<Integer> lotto) {
        Set<Integer> validLotto = new HashSet<>(lotto);
        if (validLotto.size() != lotto.size()) throw new IllegalArgumentException();
    }
}
