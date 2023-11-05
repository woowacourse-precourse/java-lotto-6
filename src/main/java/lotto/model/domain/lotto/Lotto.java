package lotto.model.domain.lotto;

import java.util.Collections;
import java.util.List;
import lotto.constance.GameConst;
import lotto.exception.LottoGameException;
import lotto.model.domain.result.LottoCompareResult;

public class Lotto {
    private static final int LOTTO_SIZE = GameConst.LOTTO_SIZE;

    //수정 금지
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateNumbersNotDuplicated(numbers);
        validateNumbersRange(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw LottoGameException.WRONG_LOTTO_SIZE.makeException();
        }
    }

    private void validateNumbersNotDuplicated(List<Integer> numbers) {
        int distinctNum = (int) numbers.stream()
                .distinct()
                .count();
        if (distinctNum != LOTTO_SIZE) {
            throw LottoGameException.DUPLICATED_LOTTO_NUMBER.makeException();
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        long wrongNumberCount = numbers.stream()
                .filter(this::isOutOfRange)
                .count();
        if (wrongNumberCount != 0) {
            throw LottoGameException.WRONG_LOTTO_RANGE.makeException();
        }
    }

    private boolean isOutOfRange(int number) {
        return number > GameConst.LOTTO_RANGE_END || number < GameConst.LOTTO_RANGE_START;
    }

    //출력을 위한 사용
    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public LottoCompareResult compareLotto(Lotto lotto) {
        int collectNumber = countCollectNumber(lotto);
        return new LottoCompareResult(collectNumber, false);
    }

    private int countCollectNumber(Lotto lotto) {
        return (int) lotto.numbers
                .stream()
                .filter(this.numbers::contains)
                .count();
    }
}
