package lotto.validator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

class BonusNumberValidatorTest {

    @Test
    @DisplayName("보너스 번호가 유효한지 확인한다.")
    void validateBonusNumber() {
        Set<Integer> winningNumbers = new HashSet<>();
        winningNumbers.add(10);
        winningNumbers.add(20);
        winningNumbers.add(30);
        winningNumbers.add(40);

        String validInput = "5";
        int validBonusNumber = BonusNumberValidator.validateBonusNumber(validInput, winningNumbers);
        assertEquals(5, validBonusNumber);

        String invalidInput = "20"; // 이미 당첨 번호로 선택된 숫자
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> BonusNumberValidator.validateBonusNumber(invalidInput, winningNumbers));
        assertEquals("[ERROR] 이미 당첨 번호로 선택된 숫자입니다.", exception.getMessage());

        String outOfRangeInput = "50"; // 1부터 45 사이의 숫자 아님
        exception = assertThrows(IllegalArgumentException.class,
                () -> BonusNumberValidator.validateBonusNumber(outOfRangeInput, winningNumbers));
        assertEquals("[ERROR] 1부터 45 사이의 숫자를 입력해 주세요.", exception.getMessage());

        String nonNumericInput = "abc"; // 숫자가 아닌 입력
        exception = assertThrows(IllegalArgumentException.class,
                () -> BonusNumberValidator.validateBonusNumber(nonNumericInput, winningNumbers));
        assertEquals("[ERROR] 숫자만 입력해 주세요.", exception.getMessage());
    }
}
