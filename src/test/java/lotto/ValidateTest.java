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
        assertDoesNotThrow(() -> Validate.validateFormat("1,2,3,4,5,6"));
        assertThrows(IllegalArgumentException.class, () -> Validate.validateFormat("1, 2, 3, a, 5"));
    }

    @Test
    @DisplayName("숫자 범위 검증")
    void numberInRangeTest() {
        assertDoesNotThrow(() -> Validate.numberInRange("1,2,3,4,5,6"));
        assertThrows(IllegalArgumentException.class, () -> Validate.numberInRange("0,1,2,3,4,5"));
        assertDoesNotThrow(() -> Validate.numberInRange(25));
        assertThrows(IllegalArgumentException.class, () -> Validate.numberInRange(46));
    }

    @Test
    @DisplayName("유니크 숫자 6개 입력 검증")
    void validSixNumberInputTest() {
        assertDoesNotThrow(() -> Validate.validSixNumberInput("1,2,3,4,5,6"));
        assertThrows(IllegalArgumentException.class, () -> Validate.validSixNumberInput("1,2,2,3,4,5"));
    }

    @Test
    @DisplayName("숫자만 포함되었는지 검증")
    void numericInputTest() {
        assertDoesNotThrow(() -> Validate.numericInput("123456"));
        assertThrows(IllegalArgumentException.class, () -> Validate.numericInput("1234a6"));
    }
    
    
    @Test
    @DisplayName("보너스번호와 당첨번호가 중복 오류 검증")
    void bonusNumberUniquenessTest() {
    	List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        assertThrows(IllegalArgumentException.class, () -> Validate.bonusNumberUniqueness(winningNumber, 6));
    }
}
