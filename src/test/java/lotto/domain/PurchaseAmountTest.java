package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {

    @DisplayName("로또 가격으로 나누어떨어지지 않는 값으로 생성하는 경우 에러")
    @Test
    void checkPurchaseAmountDivideTest() {
        assertThatThrownBy(() -> new PurchaseAmount(5001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("PurchaseAmount 생성 성공")
    @Test
    void checkCreatePurchaseAmountTest() {
        Assertions.assertThatNoException().isThrownBy(
                () -> new PurchaseAmount(5000)
        );
    }

    @DisplayName("구입 금액만큼 PurchasedLotto 생성 되는지 확인")
    @Test
    void checkCreatePurchasedLottoTest() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(5000);

        PurchasedLotto purchasedLotto = purchaseAmount.purchaseLotto();
        int size = purchasedLotto.getLottos().size();

        assertThat(size).isEqualTo(5);
    }
}
