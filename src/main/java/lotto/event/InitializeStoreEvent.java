package lotto.event;

import lotto.domain.LottoStore;
import lotto.domain.strategy.RandomLottoPublisher;
import lotto.domain.strategy.RandomNumbersGenerator;
import lotto.event.EventListener.Event;
import lotto.repository.LottoRepository;

public record InitializeStoreEvent(LottoRepository lottoRepository) implements Event {
    
    @Override
    public void execute() {
        final var randomLottoPublisher = new RandomLottoPublisher(new RandomNumbersGenerator());

        lottoRepository.save(new LottoStore(randomLottoPublisher));
    }

}
