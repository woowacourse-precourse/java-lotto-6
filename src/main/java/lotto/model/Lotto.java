package lotto.model;

import java.util.List;
import lotto.model.validator.LottoNumbersValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumbersValidator.validateLottoNumbersSize(numbers);
        LottoNumbersValidator.validateDuplicatedLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public boolean containBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
