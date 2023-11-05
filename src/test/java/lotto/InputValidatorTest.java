package lotto;

import lotto.domain.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputValidatorTest {
    InputValidator inputValidator;
    @BeforeEach
    void setUp(){
        inputValidator = new InputValidator();
    }
    @DisplayName("구입 금액이 숫자가 아니거나 양수가 아니거나 1000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1700a", "160#0", "2400-", "-24000", "10", "0", "999",""," "})
    void createPurchaseAmountNotNumber(String purchaseAmountFromPlayer) {
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(purchaseAmountFromPlayer))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
