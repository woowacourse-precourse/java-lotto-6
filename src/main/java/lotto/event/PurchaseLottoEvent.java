package lotto.event;

import java.util.stream.Collectors;
import lotto.PurchasedLottoState;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.event.EventListener.ParameterAndReturnEvent;
import lotto.repository.LottoRepository;

public record PurchaseLottoEvent(LottoRepository lottoRepository) implements ParameterAndReturnEvent<Integer, PurchasedLottoState> {
    @Override
    public PurchasedLottoState execute(Integer payment) {
        final var money = new Money(payment);
        final var store = lottoRepository.findLottoStore();
        final var purchasedLottoBundle = store.purchaseLotto(money);

        lottoRepository.save(purchasedLottoBundle);
        lottoRepository.save(money);

        return new PurchasedLottoState(
                purchasedLottoBundle.value().size(),
                purchasedLottoBundle.value()
                        .stream().map(Lotto::getNumbers)
                        .collect(Collectors.toList())
        );
    }
}
