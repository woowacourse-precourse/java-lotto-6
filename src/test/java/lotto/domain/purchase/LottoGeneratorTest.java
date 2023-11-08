package lotto.domain.purchase;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.number.Lottos;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    @Test
    void generateAutomaticallyBy() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(10_000);

        LottoGenerator lottoGenerator = new LottoGenerator();
        Lottos lottos = lottoGenerator.generateAutomaticallyBy(purchaseAmount);

        assertThat(lottos.countLottos()).isEqualTo(10);
    }
}