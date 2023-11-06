package lotto.application;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoMachine {
    public Lotto createLotto(final List<Integer> numbers) {
        return numbers.stream()
                .map(this::createLottoNumber)
                .sorted()
                .collect(collectingAndThen(toList(), Lotto::new));
    }

    public LottoNumber createLottoNumber(final int number) {
        return LottoNumber.from(number);
    }
}
