package lotto;

import lotto.generator.NumberGenerator;
import lotto.generator.RandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("구매한 로또 테스트")
class PurchasedLottosTest {

    @DisplayName("로또를 장당 1000원에 구입 금액에 해당하는 만큼 로또를 발행해야 한다.")
    @Test
    public void createPurchasedLottos_ShouldGenerateCorrectNumberOfLottos() {
        NumberGenerator generator = new RandomNumberGenerator();
        Money money = new Money("5000");
        PurchasedLottos purchasedLottos = PurchasedLottos.createPurchasedLottos(generator, money);

        Assertions.assertThat(purchasedLottos.purchasedLottosCount()).isEqualTo(5);
    }

}