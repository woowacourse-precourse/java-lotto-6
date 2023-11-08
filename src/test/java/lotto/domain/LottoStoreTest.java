package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {
    private LottoStore lottoStore;

    @BeforeEach
    void setUp() {
        lottoStore = new LottoStore();
    }

    @Test
    @DisplayName("로또 구매 가격만큼 로또를 생성한다.")
    void purchaseLotto() {
        // given
        Integer purchasePrice = 3000;

        // when
        List<Lotto> results = lottoStore.purchaseLotto(purchasePrice);

        // then
        assertThat(results.size()).isEqualTo(3);
    }
}
