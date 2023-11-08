package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoShopTest {

    private final LottoShop lottoShop = new LottoShop();

    @DisplayName("주문 받은 로또 개수만큼 로또를 발급해준다.")
    @Test
    void createLottosByNumber() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(5000);
        List<Lotto> lottos = lottoShop.createLottosBy(purchaseAmount);

        assertThat(lottos.size()).isEqualTo(5);
    }

    @DisplayName("받은 금액이 1000원으로 나누어 떨어지지 않으면 에러를 발생시킨다")
    @Test
    void createLottosByUnDivisibleAmount() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(5500);

        assertThatThrownBy(() -> lottoShop.createLottosBy(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
