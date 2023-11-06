package lotto.component;

import lotto.event.EventListener;
import lotto.event.PurchaseLottoEvent;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public record PurchaseLottoComponent(InputView inputView, OutputView outputView, EventListener eventListener) implements Component {
    @Override
    public void render() {
        final var payment = inputView.readPaymentPrice();

        final var purchasedLottoState = eventListener.listenWithParameterAndResult(PurchaseLottoEvent::new)
                .apply(payment);

        outputView.print(purchasedLottoState);

    }
}
