package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BuyerTest {

    private LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    @DisplayName("구매금액에 따른 로또 갯수 확인")
    @Test
    void buyLottoSize() {
        int amount = 2000;
        int lottoCount = new Amount(amount).buyCount();

        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lotto.add(new Lotto(lottoNumberGenerator.pickUniqueNumbers()));
        }

        Lottos lottos = new Lottos(lotto);
        Buyer buyer = new Buyer(lottos);

        Assertions.assertThat(buyer.lottoCount()).isEqualTo(2);
    }
}
