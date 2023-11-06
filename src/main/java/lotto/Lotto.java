package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.LottoConstant.*;
import static lotto.constant.LottoErrorMessage.LOTTO_LENGTH_ERROR_MESSAGE;
import static lotto.constant.LottoErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE;

public class Lotto {
    private final List<Integer> numbers;

    protected Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto make() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_LENGTH));
    }

    private void validate(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateLottoNumberDuplicate(numbers);
    }

    private void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(LOTTO_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateLottoNumberDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
