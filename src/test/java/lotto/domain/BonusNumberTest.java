package lotto.domain;

import lotto.exception.InvalidNumberFormatException;
import lotto.exception.InvalidNumberRangeException;
import lotto.exception.MissingNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BonusNumberTest {

    @DisplayName("보너스 숫자에 입력이 없을때 예외처리 테스트.")
    @Test
    void verificationTest1() {
        assertThrows(MissingNumberException.class, () -> {
            new BonusNumber("");
        });
    }

    @DisplayName("보너스 숫자에 숫자만 입력 했는지 예외처리 테스트.")
    @Test
    void verification2() {
        assertThrows(InvalidNumberFormatException.class, () -> {
            new BonusNumber("abc");
        });
    }

    @DisplayName("보너스 숫자에 1~45 사이에 숫자를 입력 했는지 예외처리 테스트.")
    @Test
    void verification3() {
        assertThrows(InvalidNumberRangeException.class, () -> {
            new BonusNumber("50");
        });
    }
}
