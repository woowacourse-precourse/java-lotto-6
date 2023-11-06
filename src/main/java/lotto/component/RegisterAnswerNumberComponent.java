package lotto.component;

import lotto.event.EventListener;
import lotto.event.RegisterAnswerNumberEvent;
import lotto.ui.InputView;

public record RegisterAnswerNumberComponent(InputView inputView, EventListener eventListener) implements Component {
    @Override
    public void render() {
        eventListener.listenWithParameter(RegisterAnswerNumberEvent::new)
                .accept(inputView.readAnswerNumber());
    }
}
