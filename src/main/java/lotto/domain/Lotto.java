package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("숫자는 6개보다 작거나 초과할 수 없습니다.");
        }
    }

    public List<Integer> randomLottery() {
        List<Integer> lotto = new ArrayList<>();
        while (lotto.size() <= 6) {
            int num = Randoms.pickNumberInRange(1, 45);
            if (!isDuplicatedNum(lotto, num)) lotto.add(num);
        }
        Collections.sort(lotto);
        return lotto;
    }

    public boolean isDuplicatedNum(List<Integer> lotto, int num) {
        if (lotto.contains(num)) return true;
        return false;
    }
}
