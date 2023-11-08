package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {

    Exception exception = new Exception();

    @DisplayName("구입금액 입력값에 숫자 이외의 값이 포함되면 예외가 발생한다.")
    @Test
    void createPurchasePriceIncludeNonNumber() {
        String input = "test000";
        assertThatThrownBy(() -> exception.validatePurchasePrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 숫자 이외의 값이 포함될 수 없습니다.");
    }

    @DisplayName("구입금액 입력값이 1000 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void createPurchasePriceNotInThousands() {
        String input = "100";
        assertThatThrownBy(() -> exception.validatePurchasePrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 1,000원 단위여야 합니다.");
    }
}
