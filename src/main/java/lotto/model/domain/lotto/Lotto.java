package lotto.model.domain.lotto;

import java.util.Collections;
import java.util.List;
import lotto.constance.GameConst;
import lotto.exception.LottoGameException;
import lotto.model.domain.result.compare.LottoCompareResult;

public class Lotto {

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
        if (numbers.size() != GameConst.LOTTO_SIZE) {
            throw LottoGameException.WRONG_LOTTO_SIZE.makeException();
        }
    }

    private void validateNumbersNotDuplicated(List<Integer> numbers) {
        int distinctNum = (int) numbers.stream()
                .distinct()
                .count();
        if (distinctNum != GameConst.LOTTO_SIZE) {
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

    /**
     * 로또가 가진 숫자들을 반환한다.
     *
     * <p>
     * 로또 객체는 기본적으로 불변성을 보장한다. 반환되는 리스트는 불변 리스트이며, 출력 등의 이유를 제외하고는 사용을 권장하지 않는다
     * </p>
     *
     * @return {@link Collections#unmodifiableList(List)} - Lotto의 숫자들을 가진 불변 리스트
     */
    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    /**
     * 로또 객체들을 비교하여 결과를 반환한다.
     *
     * <p>로또 객체의 비교는 로또 객체들이 가지고 있는 숫자 리스트를 통해 진행된다.</p>
     *
     * @param lotto 자신과 비교할 로또 객체
     * @return {@link lotto.model.domain.result.compare.LottoCompareResult} - 전달된 Lotto 객체와 자신의 로또 숫자를 비교한 결과를 반환한다.
     */
    public LottoCompareResult compareLotto(Lotto lotto) {
        int collectNumber = countCollectNumber(lotto);
        return new LottoCompareResult(collectNumber);
    }

    private int countCollectNumber(Lotto lotto) {
        return (int) lotto.numbers
                .stream()
                .filter(this.numbers::contains)
                .count();
    }
}
