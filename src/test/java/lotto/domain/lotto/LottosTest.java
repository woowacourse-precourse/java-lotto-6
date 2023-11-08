package lotto.domain.lotto;

import lotto.domain.generator.LottoNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("구입 금액만큼 로또를 생성한다.")
    @Test
    void createLottos() {
        // given
        int purchasePrice = 3000;
        Lottos lottos = new Lottos(LottoNumberGenerator.getInstance(), purchasePrice);

        // then
        Assertions.assertThat(lottos).isNotNull();
        Assertions.assertThat(lottos.getLottos().size()).isEqualTo(purchasePrice / LottoCondition.PRICE.getValue());
    }
}
