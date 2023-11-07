package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static Lotto create() {
        List<Integer> lottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNums);
    }

    public Result match(List<Integer> winnerNums, int bonusNum) {
        return null;
    }
}
