package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.utils.ExceptionMessage;
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
    void amountMinUnder() {

        // Given
        int purchaseAmount = 500;

        // When
        // Then
        assertThatThrownBy(() -> amount.calculateTotalLottoCount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_AMOUNT_RANGE);
    }

    @Test
    @DisplayName("구매 금액이 1000원 단위가 아닐 때 예외 발생")
    void amountDivision() {

        // Given
        int purchaseAmount = 12400;

        // When
        // Then
        assertThatThrownBy(() -> amount.calculateTotalLottoCount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_AMOUNT_DIVISION);
    }

    @Test
    @DisplayName("로또 한장의 가격을 구하는 테스트")
    void calculateLotto() {

        // Given
        int purchaseAmount = 10000;

        // When
        int calculatedTotalLottoCount = amount.calculateTotalLottoCount(purchaseAmount);

        // Then
        assertThat(calculatedTotalLottoCount).isEqualTo(10);
    }
}