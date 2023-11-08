package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Amount;
import lotto.domain.PurchasedLottos;
import lotto.utils.NumberGenerator;
import lotto.utils.RandomLottoNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchasedLottosTest {
    @DisplayName("장당 1000원으로 구입 금액에 해당하는 만큼 로또를 발행해야 한다.")
    @Test
    public void createPurchasedLottos_ShouldGenerateCorrectCountofLottos() {
        NumberGenerator generator = new RandomLottoNumbersGenerator();
        Amount amount = new Amount("5000");
        PurchasedLottos purchasedLottos = PurchasedLottos.createPurchasedLottos(generator, amount);

        assertThat(purchasedLottos.purchasedLottosCount()).isEqualTo(5);
    }
}
