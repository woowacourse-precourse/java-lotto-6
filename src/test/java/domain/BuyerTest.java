package domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Buyer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyerTest {

    @DisplayName("로또 수익률 계산 기능 테스트")
    @Test
    void publishLotto(){
        Buyer buyer = new Buyer(5000);
        buyer.buyLotto();

        assertThat(buyer.getYield(5000)).isEqualTo(100);
    }
}
