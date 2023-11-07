package lotto.domain;

import java.util.*;

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
        List<Integer> lotto = new ArrayList<>();
        while (lotto.size() <= LOTTO_SIZE) {
            int num = pickNumber();
            if (!isDuplicatedNum(lotto, num)) lotto.add(num);
        }
        Collections.sort(lotto);
        return lotto;
    }

    public static boolean isDuplicatedNum(List<Integer> lotto, int num) {
        return lotto.contains(num);
    }

    public void checkDuplicate(List<Integer> lotto) {
        Set<Integer> validLotto = new HashSet<>(lotto);
        if (validLotto.size() != lotto.size()) throw new IllegalArgumentException();
    }
}
