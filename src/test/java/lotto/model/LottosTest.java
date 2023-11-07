package lotto.model;

import lotto.constant.GameConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottosTest {

    @DisplayName("금액만큼 로또를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 5000, 10000})
    void createLottos(int amount) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        Lottos lottos = new Lottos(purchaseAmount);

        int expected = amount / GameConfig.LOTTO_PRICE.getValue();

        Assertions.assertThat(lottos.lottoCount()).isEqualTo(expected);
    }
}
