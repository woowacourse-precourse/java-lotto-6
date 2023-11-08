package lotto.component;

import lotto.event.EventListener;
import lotto.event.PaymentSummaryEvent;
import lotto.ui.OutputView;

public record WinningStatisticsComponent(OutputView outputView, EventListener eventListener) implements Component {
    
    @Override
    public void render() {
        final var winningStatisticsState = eventListener.listenWithResult(PaymentSummaryEvent::new);

        outputView.print(winningStatisticsState);
    }

}
