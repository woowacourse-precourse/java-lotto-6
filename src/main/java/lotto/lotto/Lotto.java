package lotto.lotto;

import static lotto.error.message.InvalidStateErrorMessage.LOTTO_NUMBERS_COUNT_NOT_SIX;
import static lotto.error.message.InvalidStateErrorMessage.LOTTO_NUMBERS_DUPLICATE;
import static lotto.error.message.InvalidStateErrorMessage.LOTTO_NUMBERS_OUT_OF_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import lotto.error.exception.InvalidStateException;
import lotto.util.IntegerUtil;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto create() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        checkNumbersCount(numbers);
        checkDuplicateNumbers(numbers);
        checkNumbersRange(numbers);
    }

    private void checkNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InvalidStateException(LOTTO_NUMBERS_COUNT_NOT_SIX.getMessage(), numbers);
        }
    }

    private void checkDuplicateNumbers(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != 6) {
            throw new InvalidStateException(LOTTO_NUMBERS_DUPLICATE.getMessage(), numbers);
        }
    }

    private void checkNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!IntegerUtil.checkNumberInRange(number, 1, 45)) {
                throw new InvalidStateException(LOTTO_NUMBERS_OUT_OF_RANGE.getMessage(), numbers);
            }
        }
    }
}
