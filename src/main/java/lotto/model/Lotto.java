package lotto.model;

import static lotto.util.validators.LottoValidator.validateLotto;

import java.util.Collections;
import java.util.List;
import lotto.util.wrapper.BonusNumber;
import lotto.util.wrapper.WinningNumbers;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        try {
            validateLotto(numbers);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void resultCompare(final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {

    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}

