package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseTest {

    @Test
    @DisplayName("8000원 투입시 로또는 8개 생성되어야한다.")
    void purchaseLottoBy8000Won() {
        // given
        Lottos lottos = new Lottos();
        // when
        Purchase purchase = Purchase.purchase(lottos, 8000);
        // then
        Assertions.assertThat(purchase.getLottos().size()).isEqualTo(8);

    }

}