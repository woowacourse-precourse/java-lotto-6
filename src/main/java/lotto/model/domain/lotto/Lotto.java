package lotto.model.domain.lotto;

import java.util.Collections;
import java.util.List;
import lotto.constance.GameConst;
import lotto.model.domain.result.CompareResult;
import lotto.exception.LottoGameException;

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
                .filter(number -> number > GameConst.LOTTO_RANGE_END ||
                        number < GameConst.LOTTO_RANGE_START)
                .count();
        if (wrongNumberCount != 0) {
            throw LottoGameException.WRONG_LOTTO_RANGE.makeException();
        }
    }

    //출력을 위한 사용
    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public CompareResult compareLotto(Lotto lotto) {
        int collectNumber = collectNumber(lotto);
        if (isCompareFinish(lotto, collectNumber)) {
            return new CompareResult(collectNumber, false);
        }
        boolean collectBonus = isCollectBonus((LottoAnswer) lotto);
        return new CompareResult(collectNumber, collectBonus);
    }

    private boolean isCompareFinish(Lotto lotto, int collectNumber) {
        return lotto.getClass() != LottoAnswer.class ||
                collectNumber != GameConst.BONUS_CHECK_NECESSARY;
    }

    private int collectNumber(Lotto lotto) {
        return (int) lotto.numbers
                .stream()
                .filter(this.numbers::contains)
                .count();
    }

    private boolean isCollectBonus(LottoAnswer answer) {
        int bonusNumber = answer.getBonusNumber();
        return this.numbers.contains(bonusNumber);
    }
}
