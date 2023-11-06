package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoStoreTest {

    @Test
    @DisplayName("로또 구입 금액에 해당하는 만큼 로또를 발행할 수 있다.")
    void buyLotto() {
        List<Lotto> lottos = LottoStore.buyLotto(2000);

        assertThat(lottos.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 구입 금액이 1,000원보다 작다면 예외가 발생한다.")
    void lessThanLottoPrice() {
        assertThatThrownBy(() -> LottoStore.buyLotto(900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 구입 금액은 최소 1000원 이상이어야 합니다.");
    }

    @Test
    @DisplayName("로또 구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    void invalidPurchaseAmount() {
        assertThatThrownBy(() -> LottoStore.buyLotto(1100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 구입 금액은 1000원 단위어야 합니다.");
    }
}