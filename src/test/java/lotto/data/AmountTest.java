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
}
