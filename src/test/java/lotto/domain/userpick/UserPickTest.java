package lotto.domain.userpick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.NoSuchElementException;

class UserPickTest {
    UserPick userPick = new UserPick();

    @DisplayName("당첨 번호의 유효성 검증에 실패하였을 때 NoSuchElementException이 발생하는지 테스트한다.")
    @Test
    void pickLottoNumbersTest() {
        // Given
        String invalidInput1 = "1,2,3,4,5,5";
//        String invalidInput2 = "1,2,3,4,5";
//        String invalidInput3 = "1,2,3,4,5,50";
        InputStream inputStream = new ByteArrayInputStream(invalidInput1.getBytes());
        System.setIn(inputStream);

        // When & Then
        Assertions.assertThrows(NoSuchElementException.class, () -> userPick.pickLottoNumbers());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되었을 때 NoSuchElementException을 발생시키는지 테스트한다.")
    @Test
    void pickBonusNumberTest() {
        // Given
        List<Integer> testLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        String input = "1";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // When & Then
        Assertions.assertThrows(NoSuchElementException.class, () -> userPick.pickBonusNumber(testLottoNumbers));
    }

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