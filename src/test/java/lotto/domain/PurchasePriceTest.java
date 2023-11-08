package lotto.domain;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchasePriceTest {

    @DisplayName("로또 구매 금액이 1000원 단위가 아닐 경우")
    @Test
    void validatorPriceUnit() {

        int purchasePrice = 1001;

        assertThatThrownBy(() -> new PurchasePrice(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INCORRECT_UNIT.getMessage());
    }

}
