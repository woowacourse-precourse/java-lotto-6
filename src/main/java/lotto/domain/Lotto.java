package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.domain.GenerateRandomNum.pickNumber;
import static lotto.utils.Constants.LOTTO_SIZE;
import static lotto.utils.ErrorMessages.CHECK_DUPLICATE_NUMBER;
import static lotto.utils.ErrorMessages.CHECK_NUMBER_SIZE;


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

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static List<Integer> randomLottery() {
        return pickNumber();
    }

    public static void checkDuplicate(List<Integer> lotto) {
        Set<Integer> validLotto = new HashSet<>(lotto);
        if (validLotto.size() != lotto.size()) throw new IllegalArgumentException(CHECK_DUPLICATE_NUMBER);
    }

    public static List<Lotto> getLotto(int cnt) {
        List<Lotto> lottery = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            Lotto lotto = new Lotto(Lotto.randomLottery());
            lottery.add(lotto);
        }
        return lottery;
    }
}
