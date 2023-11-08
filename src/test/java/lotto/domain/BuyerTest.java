package lotto.domain;

import static lotto.exception.constants.ErrorMessage.INVALID_LOTTO_FORMAT;
import static lotto.exception.constants.ErrorMessage.INVALID_PURCHASE_AMOUNT;
import static lotto.exception.constants.ErrorMessage.NOT_NUMERIC_PURCHASE_AMOUNT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyerTest {
    @DisplayName("구매자의 구입 금액이 정수가 아니면 예외가 발생한다.")
    @Test
    void createNotNumericBuyerPurchaseAmount() {
        assertThatThrownBy(() -> Buyer.of("??"))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(NOT_NUMERIC_PURCHASE_AMOUNT.getMessage());
    }

    @DisplayName("구매자의 구입 금액이 로또 구매 단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createBuyerPurchaseAmountNotDivideByUnitPrice() {
        assertThatThrownBy(() -> Buyer.of("9876"))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(INVALID_PURCHASE_AMOUNT.getMessage());
    }
}