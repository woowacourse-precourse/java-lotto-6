package lotto.validation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidationTest {

    @Test
    void 구매금액_0보다_커야함() {
        assertThatThrownBy(() -> InputValidation.validatePurchaseAmount(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]구매 금액은 0보다 커야 합니다.");
    }

    @Test
    void 구매금액은_천원_단위() {
        assertThatThrownBy(() -> InputValidation.validatePurchaseThousand(2500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]구매 금액은 1000원 단위여야 합니다.");
    }

    @Test
    void 당첨번호_보너스번호_중복() {
        assertThatThrownBy(() -> InputValidation.validateBonusNumber(10, Arrays.asList(1, 2, 3, 4, 5, 10)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]보너스 번호가 당첨 번호와 중복됩니다.");
    }
}
