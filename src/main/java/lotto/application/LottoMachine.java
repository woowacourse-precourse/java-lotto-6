package lotto.application;

import static lotto.enums.LottoConfig.LOTTO_COUNT;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoMachine {
    private final NumberGenerator numberGenerator;

    public LottoMachine(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lotto createLottoByAuto() {
        List<Integer> numbers = numberGenerator.generateNumbers(LOTTO_COUNT.getValue());
        return createLotto(numbers);
    }

    public Lotto createLottoByManual(final List<Integer> numbers) {
        return createLotto(numbers);
    }

    private Lotto createLotto(final List<Integer> numbers) {
        return new Lotto(numbers.stream()
                .map(LottoNumber::from)
                .toList()
        );
    }

    public LottoNumber createBonusNumber(final int bonus) {
        return LottoNumber.from(bonus);
    }
}
