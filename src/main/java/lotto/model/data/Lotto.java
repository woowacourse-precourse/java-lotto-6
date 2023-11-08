package lotto.model.data;

import static lotto.model.calculator.WinningCalculator.comparingBonusAndWinningNumber;
import static lotto.model.calculator.WinningCalculator.comparingLottoAndWinningNumber;
import static lotto.model.validator.LottoNumberValidator.checkCountOfNumbers;
import static lotto.model.validator.LottoNumberValidator.checkDuplicateNumbers;
import static lotto.model.validator.LottoNumberValidator.checkRangeOfNumbers;

import java.util.List;
import lotto.model.record.BonusNumber;

/**
 * 로또 번호를 나타낸다.
 */
public class Lotto {
    private final List<Integer> numbers;

    /**
     * 제공된 번호의 유효성을 검사한 후 로또를 생성한다.
     *
     * @param numbers 로또 번호
     * @throws IllegalArgumentException 유효성 검증(개수, 범위, 중복)을 통과하지 못할 경우
     */
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkCountOfNumbers(numbers);
        checkRangeOfNumbers(numbers);
        checkDuplicateNumbers(numbers);
    }

    /**
     * 로또 번호를 반환한다.
     *
     * @return 수정할 수 없는 로또 번호
     */
    public List<Integer> getNumbers() {
        return numbers;
    }

    /**
     * 당첨 번호와 로또 번호를 비교한다.
     *
     * @param winningNumbers 로또 번호와 비교할 당첨 번호
     * @return 로또 번호와 매치되는 당첨 번호의 개수
     */
    public int compareLottoAndWinningNumbers(List<Integer> winningNumbers) {
        return comparingLottoAndWinningNumber(numbers, winningNumbers);
    }

    /**
     * 보너스 번호와 로또 번호를 비교한다.
     *
     * @param bonusNumber 로또 번호와 비교할 보너스 번호
     * @return 로또 번호에 보너스 번호가 포함된다면 1을 반환한다; 포함되지 않는다면 0을 반환한다.
     */
    public int compareLottoAndBonusNumber(BonusNumber bonusNumber) {
        return comparingBonusAndWinningNumber(numbers, bonusNumber.bonusNumber());
    }
}
