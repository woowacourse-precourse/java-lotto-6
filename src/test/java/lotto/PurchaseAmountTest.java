package lotto;

import lotto.model.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {

    @DisplayName("구입 금액이 비거나 문자인 경우 에러가 발생한다.")
    @Test
    void createPurchaseAmountByIncludingNotNumber(){
        assertThatThrownBy(() -> new PurchaseAmount(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new PurchaseAmount("8000c"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 음수인 경우 예외가 발생한다.")
    @Test
    void createNegativePurchaseAmount(){
        assertThatThrownBy(() -> new PurchaseAmount("-80"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 로또 1장 가격(1000원)보다 작을 경우 예외가 발생한다.")
    @Test
    void createPurchaseAmountUnder1000(){
        assertThatThrownBy(() -> new PurchaseAmount("500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000단위가 아닌 경우 예외가 발생한다.")
    @Test
    void createPurchaseAmountBy1000Unit(){
        assertThatThrownBy(() -> new PurchaseAmount("4200"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
