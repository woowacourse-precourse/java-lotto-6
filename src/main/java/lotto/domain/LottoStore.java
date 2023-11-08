package lotto.domain;

import static lotto.domain.constant.LottoNumberConstant.LOTTO_PRICE;
import static lotto.domain.exception.DomainExceptionCode.LOTTO_PAYMENT_PRICE_REQUIRED;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.strategy.LottoPublisher;

public class LottoStore {

    private final LottoPublisher lottoPublisher;

    public LottoStore(LottoPublisher lottoPublisher) {
        this.lottoPublisher = lottoPublisher;
    }

    public PurchasedLottoBundle purchaseLotto(Money money) {
        validate(money);

        final var quantity = LOTTO_PRICE.divide(money.value());

        return new PurchasedLottoBundle(publishLottoBy(quantity));
    }

    private List<Lotto> publishLottoBy(long quantity) {
        return Stream.generate(lottoPublisher::publish)
                .limit(quantity)
                .toList();
    }

    private void validate(Money payment) {
        final var paymentValue = payment.value();

        LOTTO_PAYMENT_PRICE_REQUIRED.dynamicInvokeBy(() -> LOTTO_PRICE.isGreaterThan(paymentValue));
        LOTTO_PAYMENT_PRICE_REQUIRED.dynamicInvokeBy(() -> paymentValue % LOTTO_PRICE.getNumber() != 0);
    }
    
}
