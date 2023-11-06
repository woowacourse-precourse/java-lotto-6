package lotto.component;

import lotto.event.EventListener;
import lotto.event.RegisterBonusNumberEvent;
import lotto.ui.InputView;

public record RegisterBonusNumberComponent(InputView inputView, EventListener eventListener) implements Component {
    @Override
    public void render() {
        eventListener.listenWithParameter(RegisterBonusNumberEvent::new)
                .accept(inputView.readBonusNumber());

    }
}
