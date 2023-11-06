package lotto.component;

import lotto.event.EventListener;
import lotto.event.InitializeStoreEvent;

public record InitializeLottoStoreComponent(EventListener eventListener) implements Component {
    @Override
    public void render() {
        eventListener.listen(InitializeStoreEvent::new);
    }
}
