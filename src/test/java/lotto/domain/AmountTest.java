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
}