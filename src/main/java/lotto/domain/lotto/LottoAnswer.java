package lotto.domain.lotto;

import java.util.List;

public class LottoAnswer {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public LottoAnswer(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.lotto = new Lotto(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private void validate(List<Integer> numbers, int bonusNumber) {

    }
}
