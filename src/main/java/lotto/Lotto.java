package lotto;

import lotto.enums.LottoInfo;

import java.util.List;

import static lotto.enums.LottoInfo.MAX_NUMBER;
import static lotto.enums.LottoInfo.MIN_NUMBER;

public class Lotto {
    private final List<Integer> numbers;
    private final int LOTTO_COUNT;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        this.LOTTO_COUNT = LottoInfo.NUMBERS_PER_LOTTO.getNumber();
    }

    private void validate(List<Integer> numbers) {
        Validation.validateNotNull(numbers);
        Validation.validateInRange(MIN_NUMBER.getNumber(), MAX_NUMBER.getNumber(), numbers);
        Validation.validateLottoNumbersCount(numbers);
        Validation.validateDuplicate(numbers);
    }

    public boolean isInclude(int predict) {
        return numbers.contains(predict);
    }
}
