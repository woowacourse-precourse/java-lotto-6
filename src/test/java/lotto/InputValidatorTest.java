package lotto;

import lotto.domain.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputValidatorTest {
    InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @DisplayName("구입 금액이 숫자가 아니거나 양수가 아니거나 1000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1700a", "160#0", "2400-", "-24000", "10", "0", "999", "", " "})
    void createInvalidPurchaseAmount(String purchaseAmountFromPlayer) {
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(purchaseAmountFromPlayer))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 입력이 올바르지 않을 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,50", "1,2,3,4,5", "1,2,3,4,5,5", "1.2,3,4,5,6"})
    void createInvalidWinningNumber(String winningNumberFromPlayer) {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers(winningNumberFromPlayer))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 입력이 올바르지 않을 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"50", "1", "1.2", "1,2", "", " ", "-2"})
    void createInvalidBonusNumber(String bonusNumberFromPlayer) {
        assertThatThrownBy(() -> inputValidator.validateBonusNumber(bonusNumberFromPlayer, new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
