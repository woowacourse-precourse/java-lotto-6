package lotto.validator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.HashSet;
import java.util.Set;

class BonusNumberValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = { "5", "15", "25", "35", "45" })
    @DisplayName("보너스 번호가 유효한지 확인한다.")
    void validateBonusNumber(String input) {
        Set<Integer> winningNumbers = new HashSet<>();
        winningNumbers.add(10);
        winningNumbers.add(20);
        winningNumbers.add(30);
        winningNumbers.add(40);

        int bonusNumber = BonusNumberValidator.validateBonusNumber(input, winningNumbers);

        if (Integer.parseInt(input) <= 45 && Integer.parseInt(input) >= 1) {
            assertTrue(winningNumbers.add(bonusNumber));
        } else {
            assertFalse(winningNumbers.add(bonusNumber));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = { "20", "50", "abc" })
    @DisplayName("유효하지 않은 보너스 번호 입력 시 예외가 발생하는지 확인한다.")
    void validateInvalidBonusNumber(String input) {
        Set<Integer> winningNumbers = new HashSet<>();
        winningNumbers.add(10);
        winningNumbers.add(20);
        winningNumbers.add(30);
        winningNumbers.add(40);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> BonusNumberValidator.validateBonusNumber(input, winningNumbers));

        if (input.equals("20")) {
            assertEquals("[ERROR] 이미 당첨 번호로 선택된 숫자입니다.", exception.getMessage());
        } else if (input.equals("50")) {
            assertEquals("[ERROR] 1부터 45 사이의 숫자를 입력해 주세요.", exception.getMessage());
        } else {
            assertEquals("[ERROR] 숫자만 입력해 주세요.", exception.getMessage());
        }
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("빈값을 입력한 경우 - 예외 발생")
    void validateEmptyBonusNumber(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> PurchaseAmountValidator.parseAndValidatePurchaseAmount(input));
        assertEquals("[ERROR] 올바른 금액을 입력해 주세요.", exception.getMessage());
    }
}
