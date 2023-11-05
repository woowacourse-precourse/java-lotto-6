package lotto.domain;

import static lotto.domain.Lotto.MAX_NUMBER;
import static lotto.domain.Lotto.MIN_NUMBER;
import static lotto.domain.Lotto.NUMBER_COUNT;
import static lotto.error.ExceptionCode.EXCEED_BUY_COUNT;
import static lotto.error.ExceptionCode.INVALID_BUY_COUNT_UNIT;

import java.util.ArrayList;
import java.util.List;
import lotto.error.LottoException;

public class LottoSeller {

    private final Money LOTTO_PRICE = new Money(1000L);

    private final long MAX_COUNT = 100;

    private final NumberGenerator numberGenerator;

    public LottoSeller(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lottos buy(final Money money) {
        validateMoney(money);
        final Long count = money.divide(LOTTO_PRICE);
        final List<Lotto> lottos = generateLottos(count);
        return new Lottos(lottos);
    }

    private void validateMoney(final Money money) {
        if (!money.isThousandUnit()) {
            throw new LottoException(INVALID_BUY_COUNT_UNIT);
        }
        if (money.greaterThan(LOTTO_PRICE.multiply(MAX_COUNT))) {
            throw new LottoException(EXCEED_BUY_COUNT);
        }
    }

    private List<Lotto> generateLottos(final Long count) {
        final List<Lotto> lottos = new ArrayList<>();
        for (long index = 0L; index < count; ++index) {
            final List<Integer> integers = numberGenerator.generate(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
            lottos.add(new Lotto(integers));
        }
        return lottos;
    }
}
