package lotto.lotto;

import static lotto.error.message.InvalidStateErrorMessage.LOTTO_NUMBERS_COUNT_NOT_MATCH;
import static lotto.error.message.InvalidStateErrorMessage.LOTTO_NUMBERS_DUPLICATE;
import static lotto.error.message.InvalidStateErrorMessage.LOTTO_NUMBERS_OUT_OF_RANGE;
import static lotto.global.Constant.LOTTO_MAX_NUMBER;
import static lotto.global.Constant.LOTTO_MIN_NUMBER;
import static lotto.global.Constant.LOTTO_NUMBERS_COUNT;

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
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER.getNumber(),
                LOTTO_MAX_NUMBER.getNumber(), LOTTO_NUMBERS_COUNT.getNumber());
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
        if (numbers.size() != LOTTO_NUMBERS_COUNT.getNumber()) {
            throw new InvalidStateException(LOTTO_NUMBERS_COUNT_NOT_MATCH.getMessage());
        }
    }

    private void checkDuplicateNumbers(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LOTTO_NUMBERS_COUNT.getNumber()) {
            throw new InvalidStateException(LOTTO_NUMBERS_DUPLICATE.getMessage());
        }
    }

    private void checkNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!IntegerUtil.checkNumberInRange(number, LOTTO_MIN_NUMBER.getNumber(), LOTTO_MAX_NUMBER.getNumber())) {
                throw new InvalidStateException(LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
            }
        }
    }
}
