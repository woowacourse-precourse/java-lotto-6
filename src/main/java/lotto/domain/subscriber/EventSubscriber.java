package lotto.domain.subscriber;

import lotto.domain.event.Event;

public interface EventSubscriber<T extends Event> {
    void onEvent(T event);
}
