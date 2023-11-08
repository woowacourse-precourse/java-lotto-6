package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountLottoTest {

    @DisplayName("구매금액을 입력받고 로또 개수를 구한다")
    @Test
    void 로또구매() {
        int purchaseMoney = 5000;
        PurchaseAmountLotto purchaseAmountLotto = new PurchaseAmountLotto(purchaseMoney);
        int purchaseLotto = purchaseAmountLotto.getPurchaseLotto();
        //로또 개수 확인
        Assertions.assertThat(purchaseLotto).isEqualTo(5);
    }
}