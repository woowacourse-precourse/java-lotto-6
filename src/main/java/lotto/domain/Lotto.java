package lotto.domain;

import static lotto.validator.Validator.validateMainNumbers;

import java.util.List;
import lotto.dto.LottoTicket;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateMainNumbers(numbers);
    }

    public long countMatchingMainNumbers(WinningNumbers winningNumbers) {
        return this.numbers.stream().filter(winningNumbers::isMainNumber).count();
    }

    public boolean hasBonusNumber(WinningNumbers winningNumbers) {
        return this.numbers.stream().anyMatch(winningNumbers::isBonusNumber);
    }

    public LottoTicket toLottoTicket() {
        return new LottoTicket(this.numbers);
    }
}
