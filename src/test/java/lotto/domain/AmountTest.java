package lotto.domain;


import lotto.utils.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountTest {

    Amount amount;

    @BeforeEach
    void init() {
        amount = new Amount();
    }

    @Test
    @DisplayName("1000원 미만의 금액을 입력 했을 때 예외 발생")
    void calculateTotalLottoCount() {

        // Given
        int purchaseAmount = 500;

        // When
        // Then
        Assertions.assertThatThrownBy(() -> amount.calculateTotalLottoCount(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_AMOUNT_RANGE);
    }

    @Test
    @DisplayName("구매 금액이 1000원 단위가 아닐 때 예외 발생")
    void amount_division() {

        // Given
        int purchaseAmount = 12400;

        // When
        // Then
        Assertions.assertThatThrownBy(() -> amount.calculateTotalLottoCount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_AMOUNT_DIVISION);
    }
}