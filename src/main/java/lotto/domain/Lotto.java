package lotto.domain;

import java.util.List;
import lotto.validator.LottoValidator;

public record Lotto(List<Integer> numbers) {

    public Lotto {
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        LottoValidator lottoValidator = new LottoValidator(numbers);
        lottoValidator.validateAll();
    }

    public boolean hasMatchedNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
