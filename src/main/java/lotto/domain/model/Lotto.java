package lotto.domain.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.util.ErrorMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LENGTH_INPUT.getErrorMessage());
        }
        LottoWinnerSystem.isDistinct(numbers);
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    public static List<Integer> generateLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
