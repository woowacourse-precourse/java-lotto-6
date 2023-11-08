package lotto.domain.event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import lotto.domain.event.Event;
import lotto.domain.subscriber.EventSubscriber;

public class LottoMessageBroker {
    private final Map<Class<? extends Event>, List<EventSubscriber<? extends Event>>> subscribersMap = new HashMap<>();
    private final Queue<Event> eventQueue = new LinkedList<>();

    //EventSubscriber<E>[] 배열은 허용되지 않기때문에 위험할 수 있지만
    @SafeVarargs
    public final <E extends Event> void subscribe(Class<E> eventType, EventSubscriber<E>... subscriber) {
        subscribersMap.computeIfAbsent(eventType, k -> new ArrayList<>())
                .addAll(List.of(subscriber));
    }

    public void enqueue(Event event) {
        eventQueue.add(event);
        processQueue();
    }

    private void publish(Event event) {
        List<EventSubscriber<? extends Event>> subscribers = subscribersMap.getOrDefault(event.getClass(),
                Collections.emptyList());
        subscribers.forEach(subscriber -> invokeSubscriber(event, subscriber));
    }

    private void processQueue() {
        while (!eventQueue.isEmpty()) {
            Event event = eventQueue.poll();
            publish(event);
        }
    }

    @SuppressWarnings("unchecked")
    private <E extends Event> void invokeSubscriber(E event, EventSubscriber<?> rawSubscriber) {
        ((EventSubscriber<E>) rawSubscriber).onEvent(event);
    }

}
