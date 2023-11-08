package lotto.data;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import lotto.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AmountTest {
    @ParameterizedTest
    @DisplayName("금액 생성시 로또 한장 가격보다 작을시 예외 발생")
    @CsvSource(value = {"900", "880"})
    void createAmountByLessThenLottoPrice(String purchaseAmount) {
        assertThatThrownBy(() -> new Amount(purchaseAmount, BigDecimal.valueOf(1000)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.PURCHASE_AMOUNT_IS_LESS_THAN_LOTTO_PRICE.getMessage());
    }

    @ParameterizedTest
    @DisplayName("금액 생성시 1000원 단위가 아닐 시 예외 발생")
    @CsvSource(value = {"2330", "1234", "1001"})
    void createAmountByNotThousandWonUnits(String purchaseAmount) {
        assertThatThrownBy(() -> new Amount(purchaseAmount, BigDecimal.valueOf(1000)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.AMOUNT_IS_NOT_IN_THOUSAND_WON_UNITS.getMessage());
    }
}
