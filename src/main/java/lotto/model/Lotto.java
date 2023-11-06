package lotto.model;

import lotto.util.Constants;
import lotto.util.LottoValidation;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(final List<Integer> numbers) {
        for (Integer number : numbers) {
            LottoValidation.isPermitRange(number, Constants.LOTTO);
        }
        LottoValidation.lottoCountIsSix(numbers);
        LottoValidation.duplicateLottoNumber(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
