package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseLottoTest {

    @DisplayName("구매 개수 만큼 자동 생성 로또를 구매한다.")
    @Test
    void purchaseAutoLottoByCount() {
        //given
        final int purchaseCount = 5;

        //when
        PurchaseLotto purchaseLotto = PurchaseLotto.purchaseAutoLotto(purchaseCount);

        //then
        assertThat(purchaseLotto.getAmount()).isEqualTo(purchaseCount);
    }

}