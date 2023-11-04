package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.domain.validation.LottoValidator;

public class LottoTicket {
    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        LottoValidator.validateLottoNumbers(numbers);
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
