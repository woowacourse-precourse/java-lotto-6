package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoPurchaseAmountTest {

    @DisplayName("유효하지 않은 구매 금액 입력 시 예외를 발생시킨다.")
    @ParameterizedTest(name = "[{index}] invalidPurchaseAmount: {arguments}")
    @ValueSource(strings = {"-1000", "0", "1000j", "abc", "2500"})
    void givenInvalidPurchaseAmount_whenCreatingLottoPurchaseAmount_thenThrowsException(String invalidPurchaseAmount) {
        // Then
        assertThatThrownBy(() -> new LottoPurchaseAmount(invalidPurchaseAmount))
                .isInstanceOfAny(NumberFormatException.class, IllegalArgumentException.class);
    }

    @DisplayName("유효한 구매 금액 입력 시 티켓 개수를 얻을 수 있다.")
    @ParameterizedTest(name = "[{index}] purchaseAmount: {arguments}")
    @ValueSource(strings = {"1_000", "100_000", "1_000_000", "3_333_000"})
    void givenValidPurchaseAmount_whenCreateLottoPurchaseAmount_thenReturnsCorrectTicketsCount(
            String rawPurchaseAmount) {
        // Given
        String sanitizedPurchaseAmount = rawPurchaseAmount.replace("_", "");

        int expectedTicketsCount =
                Integer.parseInt(sanitizedPurchaseAmount) / LottoPurchaseAmount.AMOUNT_PER_TICKET;

        // When
        LottoPurchaseAmount actualLottoPurchaseAmount = new LottoPurchaseAmount(sanitizedPurchaseAmount);

        // Then
        Assertions.assertThat(actualLottoPurchaseAmount.getTicketsCount()).isEqualTo(expectedTicketsCount);
    }
}
