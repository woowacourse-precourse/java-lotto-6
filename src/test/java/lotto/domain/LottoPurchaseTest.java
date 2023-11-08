package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPurchaseTest {
    @DisplayName("로또 1개를 발행한다.")
    @Test
    void purchaseUnitLotto() {
        // given
        long money = 1000;
        int purchaseCount = (int) money / 1000;
        List<Lotto> lottos;

        // when
        lottos = LottoPurchase.buyLotto(purchaseCount);

        // then
        assertThat(lottos.size()).isEqualTo(purchaseCount);
    }

    @DisplayName("로또 여러 개를 발행한다.")
    @ParameterizedTest
    @ValueSource(longs = {3000, 5000, 70000, 140000})
    void purchaseManyLotto(long money) {
        // given
        int purchaseCount = (int) money / 1000;
        List<Lotto> lottos;

        // when
        lottos = LottoPurchase.buyLotto(purchaseCount);

        // then
        assertThat(lottos.size()).isEqualTo(purchaseCount);
    }
}
