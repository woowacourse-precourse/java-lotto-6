package lotto.event;

import lotto.domain.LottoStore;
import lotto.domain.strategy.RandomLottoPublisher;
import lotto.domain.strategy.RandomNumbersGenerator;
import lotto.event.EventListener.Event;
import lotto.repository.LottoRepository;

public record InitializeStoreEvent(LottoRepository lottoRepository) implements Event {
    @Override
    public void execute() {
        lottoRepository.save(new LottoStore(new RandomLottoPublisher(new RandomNumbersGenerator())));
    }
}
