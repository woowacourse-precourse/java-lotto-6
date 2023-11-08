package lotto.model.domain.lotto.lottogenerator;

import java.util.List;
import lotto.constance.GameConst;
import lotto.exception.LottoGameException;
import lotto.model.domain.lotto.Lotto;

/**
 * 고정된 값의 {@link Lotto}를 반복하여 생성합니다.
 */
public class FixedValueLottoGenerator extends LottoGenerator<Lotto> {

    private final List<Integer> numbers;

    public FixedValueLottoGenerator(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplication(numbers);
    }

    private void validateDuplication(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw LottoGameException.DUPLICATED_LOTTO_NUMBER.makeException();
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.size() != numbers.stream()
                .distinct().count();
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != GameConst.LOTTO_SIZE) {
            throw LottoGameException.WRONG_LOTTO_SIZE.makeException();
        }
    }

    @Override
    public Lotto generate() {
        return new Lotto(this.numbers);
    }
}
