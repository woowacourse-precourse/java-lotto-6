package lotto;

import lotto.exception.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ValidatorTest {
    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void noPurchaseAmountNotMultipleOf1000() {
        String amount = "3001";
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
    }

    @DisplayName("구입 금액이 1,000원 이상이 아니면 예외가 발생한다.")
    @Test
    void noPurchaseAmountMinimumValue() {
        String amount = "0";
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
    }

    @DisplayName("숫자로만 이루어지지 않았다면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"asd", "100 0", "199a"})
    void noDigit(String amount) {
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능 합니다.");
    }

    @DisplayName("1~45 사이의 숫자가 아니라면 예외가 발생한다.")
    @Test
    void noNumberRange() {
        assertThatThrownBy(() -> Validator.validateWinningNumbers("1,2,3,4,5,47"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("중복된 숫자가 있다면 예외가 발생한다.")
    @Test
    void duplicateWinningNumber() {
        assertThatThrownBy(() -> Validator.validateWinningNumbers("1,2,3,5,5,45"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 숫자는 입력 불가능합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되면 예외가 발생한다.")
    @Test
    void containBonusNumberOfWinningNumbers() {
        assertThatThrownBy(() -> Validator.validateBonusNumber("1", Arrays.asList(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}