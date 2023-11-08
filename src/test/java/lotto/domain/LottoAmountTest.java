package lotto.domain;

import static lotto.domain.LottoAmount.price;
import static lotto.domain.LottoAmount.priceCalculation;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;

class LottoAmountTest {

    @Test
    void  로또_금액_예외_테스트() {
        assertThatThrownBy(() -> LottoAmount.purchaseAmount(20))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void  금액별_티켓_개수_테스트() {
        LottoAmount.price = 2000;
        assertThat(priceCalculation()).isEqualTo(2);
        price = 30000;
        assertThat(priceCalculation()).isEqualTo(30);
    }

}