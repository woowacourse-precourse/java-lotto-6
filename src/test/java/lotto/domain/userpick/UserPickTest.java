package lotto.domain.userpick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserPickTest {
    UserPick userPick = new UserPick();

    @DisplayName("NumberFormatException 발생 시 IllegalArgumentException을 발생시키는지 테스트한다.")
    @Test
    void parseLottoNumbersTest() {
        // Given
        String[] validNumbers = {"1", "2", "3", "4", "5", "6"};
        String[] invalidNumbers = {"1", "2", "3", "4", "5", "abc"};

        // When & Then
        Assertions.assertDoesNotThrow(() -> userPick.parseLottoNumbers(validNumbers));
        Assertions.assertThrows(IllegalArgumentException.class, () -> userPick.parseLottoNumbers(invalidNumbers));
    }

    @DisplayName("NumberFormatException 발생 시 IllegalArgumentException을 발생시키는지 테스트한다.")
    @Test
    void parseBonusNumbersTest() {
        // Given
        String validNumber = "1";
        String invalidNumber = "a";

        // When & Then
        Assertions.assertDoesNotThrow(() -> userPick.parseBonusNumber(validNumber));
        Assertions.assertThrows(IllegalArgumentException.class, () -> userPick.parseBonusNumber(invalidNumber));
    }
}