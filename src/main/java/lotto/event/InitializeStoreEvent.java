package lotto.event;

import lotto.domain.LottoStore;
import lotto.event.EventListener.Event;
import lotto.repository.LottoRepository;

public record InitializeStoreEvent(LottoRepository lottoRepository) implements Event {
    @Override
    public void execute() {
        lottoRepository.save(new LottoStore());
    }
}
