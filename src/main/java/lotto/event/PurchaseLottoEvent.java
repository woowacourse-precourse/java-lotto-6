package lotto.event;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.event.EventListener.ParameterAndReturnEvent;
import lotto.repository.LottoRepository;
import lotto.state.PurchasedLottoState;

public record PurchaseLottoEvent(LottoRepository lottoRepository) implements ParameterAndReturnEvent<Integer, PurchasedLottoState> {

    @Override
    public PurchasedLottoState execute(Integer paymentInput) {
        final var payment = new Money(paymentInput);
        final var store = lottoRepository.findLottoStore();
        final var purchasedLottoBundle = store.purchaseLotto(payment);

        lottoRepository.save(purchasedLottoBundle);
        lottoRepository.save(payment);

        return new PurchasedLottoState(
                purchasedLottoBundle.getQuantity(),
                purchasedLottoBundle.convert(Lotto::getNumbers)
        );
    }
    
}
