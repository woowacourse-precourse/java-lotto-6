package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidationTest {

    @DisplayName("구매금액이 0보다 작으면 예외가 발생한다.")
    @Test
    void zeroOverPriceTest() {
        assertThatThrownBy(() -> InputValidation.validatePurchaseAmount(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]구매 금액은 0보다 커야 합니다.");
    }

    @DisplayName("구매 금액은 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void PriceThousandUnitTest() {
        assertThatThrownBy(() -> InputValidation.validatePurchaseThousand(2500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]구매 금액은 1000원 단위여야 합니다.");
    }

    @DisplayName("보너스 번호와 당첨 번호가 중복되면 예외가 발생한다.")
    @Test
    void BonusNumberLottoDuplicate() {
        assertThatThrownBy(() -> InputValidation.validateBonusNumber(10, Arrays.asList(1, 2, 3, 4, 5, 10)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]보너스 번호가 당첨 번호와 중복됩니다.");
    }
}
