package lotto.service;

import lotto.exception.BonusNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusNumberServiceTest {

    @Test
    @DisplayName("보너스 번호 형식 검증")
    void testEnsureValidFormat() {
        // 유효한 형식의 보너스 번호
        assertDoesNotThrow(() -> BonusNumberException.ensureValidFormat("10"));

        // 유효하지 않은 형식의 보너스 번호
        assertThrows(BonusNumberException.class,
                () -> BonusNumberException.ensureValidFormat("invalid"));
    }
}