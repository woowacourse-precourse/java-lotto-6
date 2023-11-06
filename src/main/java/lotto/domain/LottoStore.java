package lotto.domain;

import java.util.stream.Stream;
import lotto.domain.strategy.LottoPublisher;

public class LottoStore {

    private final LottoPublisher lottoPublisher;


    public LottoStore(LottoPublisher lottoPublisher) {
        this.lottoPublisher = lottoPublisher;
    }

    public PurchasedLottoBundle purchaseLotto(Money money) {
        validate(money);

        final var count = money.value() / 1000;

        return new PurchasedLottoBundle(Stream.generate(lottoPublisher::publish)
                .limit(count)
                .toList());

    }

    private void validate(Money money) {
        if (money.value() == 0 || money.value() % 1000 != 0) {
            throw new IllegalArgumentException("로또의 구매 단위는 1000원 입니다.");
        }
    }
}
