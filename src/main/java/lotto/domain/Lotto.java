package lotto.domain;

import static lotto.constants.ExceptionMessage.ERROR_PREFIX;
import static lotto.constants.ExceptionMessage.EXCEPTION_DUPLICATED;
import static lotto.constants.ExceptionMessage.EXCEPTION_WRONG_LENGTH;
import static lotto.constants.LottoConstants.LOTTO_LENGTH;
import static lotto.constants.LottoConstants.MAXIMUM_NUM;
import static lotto.constants.LottoConstants.MINIMUM_NUM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicated(numbers);
        this.numbers = numbers;
    }

    public Lotto() {
        this.numbers = makeSixSortedLottoNum();
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(ERROR_PREFIX + EXCEPTION_WRONG_LENGTH);
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        for (int number : numbers) {
            if (numbers.contains(number)) {
                throw new IllegalArgumentException(ERROR_PREFIX + EXCEPTION_DUPLICATED);
            }
        }
    }

    private List<Integer> makeSixSortedLottoNum() {
        List<Integer> sixLottoNum = Randoms.pickUniqueNumbersInRange(MINIMUM_NUM, MAXIMUM_NUM, LOTTO_LENGTH);
        List<Integer> sortedLottoNum = new ArrayList<>(sixLottoNum);
        sortedLottoNum.sort((a, b) -> a - b);
        return sortedLottoNum;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
