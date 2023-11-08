package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.math.BigInteger;
import lotto.constant.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseProcessorTest {
    private static final long expectedLottoCount = 3;

    @DisplayName("올바른 가격으로 로또 수량 계산")
    @Test
    void validPrice() {
        PurchaseProcessor purchaseProcessor = new PurchaseProcessor("3000");
        assertThat(purchaseProcessor.getLottoCount()).isEqualTo(expectedLottoCount);
    }

    @DisplayName("입력 가격이 숫자 형식이 아닐 경우 예외 발생")
    @Test
    void invalidPriceFormat() {
        assertThatThrownBy(() -> new PurchaseProcessor("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_NUMBER.getMessage());
    }

    @DisplayName("입력 가격이 범위를 초과할 경우 예외 발생")
    @Test
    void priceOutOfRange() {
        assertThatThrownBy(
                () -> new PurchaseProcessor(BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE).toString()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_AMOUNT_PRICE_MESSAGE.getMessage());
    }

    @DisplayName("입력 가격이 음수일 경우 예외 발생")
    @Test
    void priceIsNegative() {
        assertThatThrownBy(() -> new PurchaseProcessor("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_NOT_ZERO.getMessage());
    }

    @DisplayName("입력 가격이 1000으로 나누어 떨어지지 않을 경우 예외 발생")
    @Test
    void priceIsNotMultipleOfThousand() {
        assertThatThrownBy(() -> new PurchaseProcessor("2500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.LOTTO_INPUT_AMOUNT_INCREMENT.getMessage());
    }

    @DisplayName("입력 가격이 0일 경우 예외 발생")
    @Test
    void priceIsZero() {
        assertThatThrownBy(() -> new PurchaseProcessor("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_NOT_ZERO.getMessage());
    }

    @DisplayName("입력 가격 내부에 공백이 있을 경우 예외 발생")
    @Test
    void validateEnsureNotBlank() {
        assertThatThrownBy(() -> new PurchaseProcessor("80 00"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.PLEASE_NOT_INPUT_BETWEEN_NUMBER_BLANK.getMessage());
    }

}

