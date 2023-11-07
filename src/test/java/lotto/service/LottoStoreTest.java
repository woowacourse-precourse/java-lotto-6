package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.service.LottoStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {
    private LottoStore lottoStore;
    @BeforeEach
    void setUp() {
        lottoStore = new LottoStore();
    }

    @DisplayName("구매 금액을 1000으로 나눠서 그 수만큼 로또를 생성한다.")
    @Test
    void createLottoByDividedPurchaseAmount() {
        //Given
        int purchaseAmount = 2000;
        //When
        List<Lotto> lottos = lottoStore.createLottos(purchaseAmount);
        //Then
        assertThat(lottos.size()).isEqualTo(2);
    }
}
