package lotto.domain.purchaser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Nested
@DisplayName("구입 금액 입력 테스트")
public class PurchaserTest {

    @DisplayName("구매 금액 - 숫자를 입력하지 않은 경우")
    @Test
    void testPurchaseAmountNotNumericInput() {
        String input = "character";
        assertThatThrownBy(() -> new Purchaser(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액 - 로또 금액과 나누어 떨어지지 않는 경우")
    @Test
    void testPurchaseAmountNotDivisibilityByLottoPrice() {
        String input = "1100";
        assertThatThrownBy(() -> new Purchaser(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액 - 올바른 입력을 한 경우")
    @Test
    void testPurchaseAmount() {
        String input = "23000";
        assertThatCode(() -> new Purchaser(input))
                .doesNotThrowAnyException();
    }
}
