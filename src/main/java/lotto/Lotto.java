package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
    public static Lotto createWinningNumbers() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(Const.winningRangeStartNumber, Const.winningRangeEndNumber, Const.LottoCount));
    }

    private void duplicateValidate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!nonDuplicateNumbers.add(number)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
