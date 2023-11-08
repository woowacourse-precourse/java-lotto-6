package lotto.domain.publisher;

import lotto.domain.event.LottoMessageBroker;
import lotto.domain.event.Event;

public class LottoEventPublisher {

    private final LottoMessageBroker lottoMessageBroker;

    public LottoEventPublisher(LottoMessageBroker lottoMessageBroker) {
        this.lottoMessageBroker = lottoMessageBroker;
    }

    public void publishEvent(Event lottoEvent) {
        lottoMessageBroker.enqueue(lottoEvent);
    }

}
