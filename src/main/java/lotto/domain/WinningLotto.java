package lotto.domain;

import java.util.List;
import static lotto.validator.BonusNumberValidator.validate;
import static lotto.validator.LottoValidator.validate;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        validate(numbers);
        validate(bonusNumber, numbers);

        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
