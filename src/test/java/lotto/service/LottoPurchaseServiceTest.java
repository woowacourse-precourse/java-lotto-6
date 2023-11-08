package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseServiceTest {

    private final NumberGenerator mockNumberGenerator = new NumberGenerator() {
        @Override
        public List<Integer> generateNumbers() {
            return IntStream.rangeClosed(1, 6).boxed().collect(Collectors.toList());
        }
    };

    private final LottoPurchaseService lottoPurchaseService;

    LottoPurchaseServiceTest() {
        LottoStore from = LottoStore.from(mockNumberGenerator);
        this.lottoPurchaseService = new LottoPurchaseService(from);
    }

    @Test
    @DisplayName("로또 구매 서비스를 통한 로또 구매 테스트")
    void buyLottos() {
        List<Lotto> purchasedLottos = lottoPurchaseService.buyLottos(2000);

        assertThat(purchasedLottos.size()).isEqualTo(2);
        purchasedLottos.forEach(lotto -> {
            List<Integer> numbers = lotto.numbers();
            assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
        });
    }
}
