package lotto.service;

import java.util.List;
import java.util.stream.IntStream;
import lotto.Money;
import lotto.domain.RandomLottoGenerator;
import lotto.domain.Lotto;

public class LottoMachine {
    public List<Lotto> makeLottosWith(Money money) {
        int numberOfLotto = money.perUnit();
        return IntStream.range(0, numberOfLotto)
                .mapToObj(integer -> RandomLottoGenerator.generateLotto())
                .toList();
    }
}
