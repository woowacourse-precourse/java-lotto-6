package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountCalculatorTest {

    @Test
    @DisplayName("구입 금액으로 구매 계산 기능 확인 테스트입니다.")
    void 구입_금액으로_구매_계산_기능_확인() {
        // Given
        int numberOfLottoPurchased;
        AmountCalculator amountCalculator = new AmountCalculator(8000);

        // When
        numberOfLottoPurchased = amountCalculator.getNumberOfLottoPurchased();

        // Then
        assertThat(numberOfLottoPurchased).isEqualTo(8);

    }
}