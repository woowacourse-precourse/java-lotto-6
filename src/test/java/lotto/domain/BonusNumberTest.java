package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @DisplayName("보너스 번호가 당첨 번호와 중복이면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
        });
    }

    @DisplayName("보너스 번호가 1에서 45까지의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createBonusNumberByOverRange() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 46);
        });
    }
}