package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoShopTest {
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    LottoShop lottoShop = new LottoShop(lottoNumberGenerator);

    @ParameterizedTest
    @ValueSource(ints = {10, 20, 5})
    void 로또구매_테스트(int amount) {
        List<Lotto> sell = lottoShop.sell(amount);
        assertThat(sell.size()).isEqualTo(amount);
    }
}
