package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ShopTest {

    @Test
    @DisplayName("Shop의 로또 금액으로 나누어 떨어질 시 그 몫만큼 로또들이 생성된다.")
    public void remainZeroTest() {
        // given
        Investor investor = Investor.createDefault("5000");
        Shop shop = Shop.withOrderedMoney(investor.getInvestMoney());

        // when
        List<Lotto> boughtLottos = investor.buyLottosFromShop(shop);

        // then
        assertThat(boughtLottos.size()).isEqualTo(5);
    }
}
