package lotto.domain;

import lotto.util.ExceptionMessage;
import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseLottoTest {
    @DisplayName("로또 구매 금액이 0인 경우 예외가 발생한다.")
    @Test
    void enterZero(){
        int purchaseMoney = 0;

        assertThatThrownBy(() -> new PurchaseLotto(purchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액이 로또 금액(1000)의 배수가 아닌 경우 예외가 발생한다.")
    @Test
    void enterNotMultipleOfLottoPrice(){
        int purchaseMoney = 12345;

        assertThatThrownBy(() -> new PurchaseLotto(purchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
