package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ErrorValidationTest {

	@DisplayName("입력값이 ,로 구분된 정수로 된 문자열이 아니면 예외가 발생한다.")
    @Test
    void testValidateComma() {
        assertThatThrownBy(() -> ErrorValidation.validateComma("1,2,3,4,5 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
	
	@DisplayName("1-45가 아닌 보너스 점수를 입력하면 예외가 발생한다.")
    @Test
    void testValidateBonusNumberRange() {
		List<Integer> testWinningNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> ErrorValidation.validateBonus("46", testWinningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
	
	@DisplayName("당첨번호와 중복되는 보너스 점수를 입력하면 예외가 발생한다.")
    @Test
    void testValidateBonusNumberDuplication() {
		List<Integer> testWinningNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> ErrorValidation.validateBonus("1", testWinningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
	
	@DisplayName("1000-100000가 아닌 구매금액을 입력하면 예외가 발생한다.")
    @Test
    void testValidatePurchaseAmountLimit() {
        assertThatThrownBy(() -> ErrorValidation.validatePurchase("999"))
                .isInstanceOf(IllegalArgumentException.class);
    }
	
	@DisplayName("1000으로 나누어지지 않는 구매금액을 입력하면 예외가 발생한다.")
    @Test
    void testValidatePurchaseAmount1000() {
        assertThatThrownBy(() -> ErrorValidation.validatePurchase("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }
	
	@DisplayName("1-45가 아닌 당첨번호를 입력하면 예외가 발생한다.")
    @Test
    void testValidateWinningNumberSize() {
		List<Integer> testWinningNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 46));
        assertThatThrownBy(() -> ErrorValidation.validateWinningNumbers(testWinningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
	
	@DisplayName("중복되는 당첨번호를 입력하면 예외가 발생한다.")
    @Test
    void testValidateWinningNumberDuplication() {
		List<Integer> testWinningNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 5));
        assertThatThrownBy(() -> ErrorValidation.validateWinningNumbers(testWinningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
