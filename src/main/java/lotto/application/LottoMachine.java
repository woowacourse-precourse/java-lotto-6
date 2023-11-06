package lotto.application;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoMachine {
    public Lotto createLotto(final List<Integer> numbers) {
        return new Lotto(numbers.stream()
                .map(this::createLottoNumber)
                .sorted()
                .toList()
        );
    }

    public LottoNumber createLottoNumber(final int number) {
        return LottoNumber.from(number);
    }
}
