package lotto.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BonusNumberTest {
    @ParameterizedTest
    @CsvSource({
            "0",
            "-1",
            "46"
    })
    @DisplayName("보너스 번호 범위 실패 테스트")
    void invalidRange(int bonusNumber) {
        assertThrows(IllegalArgumentException.class,
                () -> new BonusNumber(bonusNumber));
    }

    @ParameterizedTest
    @CsvSource({
            "1",
            "33",
            "45"
    })
    @DisplayName("보너스 번호 범위 성공 테스트")
    void validRange(int bonusNumber) {
        assertDoesNotThrow(
                () -> new BonusNumber(bonusNumber));
    }
}
