package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoGeneratorTest {
    @Test
    @DisplayName("구입한 갯수만큼 로또를 생성한다.")
    public void createLottosTest() throws Exception {
        // given
        int money = 10000;
        LottoPurchase lottoPurchase = LottoPurchase.of(money);

        // when
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lottos lottos = lottoGenerator.buyLottos(lottoPurchase);

        // then
        List<Lotto> purchaseLottos = lottos.getLottos();
        Assertions.assertThat(purchaseLottos.size()).isEqualTo(10);
    }
}
