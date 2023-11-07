package lotto.component;

import lotto.event.EventListener;
import lotto.event.PurchaseLottoEvent;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public record PurchaseLottoComponent(
        InputView inputView,
        OutputView outputView,
        EventListener eventListener
) implements Component {

    @Override
    public void render() {

        final var purchasedLottoState = eventListener.listenWithParameterAndResult(PurchaseLottoEvent::new)
                .apply(inputView.readPaymentPrice());

        outputView.print(purchasedLottoState);
    }
}
