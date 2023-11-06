package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoShopTest {
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    LottoShop lottoShop = new LottoShop(lottoNumberGenerator);
    @Test
    void 로또구매_테스트() {
        List<Lotto> sell = lottoShop.sell(10);
        Assertions.assertThat(sell.size()).isEqualTo(10);
    }
}
