package lotto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.validate.Validate;

class ValidateTest {
	@Test
    @DisplayName("입력 형식 검증")
    void validateFormatTest() {
        assertDoesNotThrow(() -> Validate.checkFormat("1,2,3,4,5,6"));
        assertThrows(IllegalArgumentException.class, () -> Validate.checkFormat("1, 2, 3, a, 5"));
    }

    @Test
    @DisplayName("숫자 범위 검증")
    void numberInRangeTest() {
        assertDoesNotThrow(() -> Validate.checkValidSixNumberInput("1,2,3,4,5,6"));
        assertThrows(IllegalArgumentException.class, () -> Validate.checkNumberInRange("0,1,2,3,4,5"));
        assertDoesNotThrow(() -> Validate.checkSingleNumberInRange(25));
        assertThrows(IllegalArgumentException.class, () -> Validate.checkSingleNumberInRange(46));
    }

    @Test
    @DisplayName("유니크 숫자 6개 입력 검증")
    void validSixNumberInputTest() {
        assertDoesNotThrow(() -> Validate.checkValidSixNumberInput("1,2,3,4,5,6"));
        assertThrows(IllegalArgumentException.class, () -> Validate.checkValidSixNumberInput("1,2,2,3,4,5"));
    }

    @Test
    @DisplayName("숫자만 포함되었는지 검증")
    void numericInputTest() {
        assertDoesNotThrow(() -> Validate.checkNumericInput("123456"));
        assertThrows(IllegalArgumentException.class, () -> Validate.checkNumericInput("1234a6"));
    }
    
    
    @Test
    @DisplayName("보너스번호와 당첨번호가 중복 오류 검증")
    void bonusNumberUniquenessTest() {
    	List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        assertThrows(IllegalArgumentException.class, () -> Validate.checkBonusNumberUniqueness(winningNumber, 6));
    }
}
