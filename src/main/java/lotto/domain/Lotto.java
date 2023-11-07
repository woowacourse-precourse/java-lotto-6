package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static lotto.domain.GenerateRandomNum.pickNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        this.numbers = numbers;
    }

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("숫자는 6개보다 작거나 초과할 수 없습니다.");
        }
    }

    public static List<Integer> randomLottery() {
        List<Integer> lotto = new ArrayList<>();
        while (lotto.size() <= 6) {
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
