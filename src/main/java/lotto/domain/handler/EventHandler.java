package lotto.domain.handler;

import lotto.domain.event.Event;

public interface EventHandler<E extends Event> {
    void handle(E event);
}
