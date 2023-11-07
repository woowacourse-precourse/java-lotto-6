package lotto.event;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.strategy.LottoPublisher;
import lotto.repository.LottoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("[이벤트] 구매 이벤트 테스트")
class PurchaseLottoEventTest {

    @Test
    void 로또를_정상적으로_구매합니다() {
        final var numbers = List.of(
                List.of(6, 5, 4, 3, 2, 1),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7),
                List.of(7, 6, 5, 4, 3, 2)
        );
        final var repository = new LottoRepository();
        final var purchaseLottoEvent = new PurchaseLottoEvent(repository);

        final var store = new LottoStore(new FakeLottoPublisher(numbers));
        repository.save(store);
        final var state = purchaseLottoEvent.execute(4000);

        assertAll(
                () -> assertThat(state.quantity()).isEqualTo(4),
                () -> assertThat(state.value()).isEqualTo(numbers)
        );

    }

    static class FakeLottoPublisher implements LottoPublisher {
        private final Queue<Lotto> lottoBundle;

        public FakeLottoPublisher(List<List<Integer>> lottoBundle) {
            this.lottoBundle = new LinkedList<>(lottoBundle.stream()
                    .map(Lotto::new)
                    .toList());
        }

        @Override
        public Lotto publish() {
            return lottoBundle.poll();
        }
    }
}