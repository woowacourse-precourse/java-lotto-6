package lotto.domain.userpick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ValidatorTest {
    Validator validator = new Validator();

    @DisplayName("당첨 번호에 대한 유효성 검증을 테스트한다.")
    @Test
    void validateSeparatedLottoNumbersTest() {
        // Given
        String[] validNumbers = {"1","2","3","4","5","6"};
        String[] invalidNumbers1 = {"1","2","3","4","5"};
        String[] invalidNumbers2 = {"1","2","3","4","5","abc"};

        // When & Then
        Assertions.assertDoesNotThrow(() -> validator.validateSeparatedLottoNumbers(validNumbers));
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validateSeparatedLottoNumbers(invalidNumbers1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validateSeparatedLottoNumbers(invalidNumbers2));
    }

    @DisplayName("보너스 번호에 대한 유효성 검증을 테스트한다.")
    @Test
    void validateBonusNumberTest() {
        // Given
        List<Integer> parsedLottoNumbers = List.of(2, 3, 4, 5, 6, 7);
        String validBonusNumber = "1";
        String invalidBonusNumber1 = "0";
        String invalidBonusNumber2 = "abc";
        String invalidBonusNumber3 = "5";

        // When & Then
        Assertions.assertDoesNotThrow(() -> validator.validateBonusNumber(validBonusNumber, parsedLottoNumbers));
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validateBonusNumber(invalidBonusNumber1, parsedLottoNumbers));
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validateBonusNumber(invalidBonusNumber2, parsedLottoNumbers));
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validateBonusNumber(invalidBonusNumber3, parsedLottoNumbers));
    }

    @DisplayName("수가 범위를 벗어나면 IllegalArgumentException을 발생시킨다.")
    @Test
    void validateRangeTest() {
        // Given
        int validNumber = 1;
        int invalidNumber = 0;

        // When & Then
        Assertions.assertDoesNotThrow(() -> validator.validateRange(validNumber));
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validateRange(invalidNumber));
    }
}