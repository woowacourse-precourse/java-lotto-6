package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPurchaseTest {
    @DisplayName("로또 1개를 발행한다.")
    @Test
    void purchaseUnitLotto() {
        // given
        long money = 1000;
        long purchaseCount = money / 1000;
        List<Lotto> lottos;

        // when
        lottos = LottoPurchase.buyLotto(money);

        // then
        assertThat(lottos.size()).isEqualTo(purchaseCount);
    }

    @DisplayName("로또 여러 개를 발행한다.")
    @ParameterizedTest
    @ValueSource(longs = {3000, 5000, 70000, 140000})
    void purchaseManyLotto(long money) {
        // given
        long purchaseCount = money / 1000;
        List<Lotto> lottos;

        // when
        lottos = LottoPurchase.buyLotto(money);

        // then
        assertThat(lottos.size()).isEqualTo(purchaseCount);
    }

    @DisplayName("투입금액이 1000원 이하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(longs = {0, 100, 500, 900, 999})
    void lackMoneyException(long money) {
        assertThatThrownBy(() -> LottoPurchase.buyLotto(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 1,000원 이상 투입 되어야 합니다.");
    }

    @DisplayName("투입금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(longs = {1001, 1500, 9700, 15000006})
    void wrongMoneyException(long money) {
        assertThatThrownBy(() -> LottoPurchase.buyLotto(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 1,000원 단위로 투입 되어야 합니다.");
    }
}
