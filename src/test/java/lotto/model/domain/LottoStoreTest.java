package lotto.model.domain;

import java.util.List;
import lotto.model.constant.LottoConstant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoStoreTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 10000, 100000, 10000000})
    void lottoPurchaseTest(int money) {
        //given
        LottoStore lottoStore = LottoStore.getInstance();

        //when
        List<Lotto> purchasedLotto = lottoStore.buyLotto(money);

        //then
        Assertions.assertThat(purchasedLotto.size()).isEqualTo(money / LottoConstant.LOTTO_PRICE.getNumber());
    }

}