package lotto.model;

import java.util.List;
import lotto.model.number.LottoNumber;
import lotto.model.number.LottoNumbers;

public class Lotto {
    private final LottoNumbers numbers;

    public Lotto(LottoNumbers numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(LottoNumbers numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public LottoNumbers getNumbers() {
        return numbers;
    }

    public LottoNumbers getSortedNumbers() {
        return new LottoNumbers(numbers.getSortedNumbers());
    }
}
