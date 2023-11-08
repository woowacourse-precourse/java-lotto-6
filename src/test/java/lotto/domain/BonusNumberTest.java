package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {

    @DisplayName("보너스 번호가 1미만 45초과면 예외가 발생한다.")
    @Test
    void validate() {

        //given
        final int case1 = 1;
        final int case2 = -1;
        final int case3 = 46;

        //when & then
        assertDoesNotThrow(() -> {
            BonusNumber bonusNumber1 = new BonusNumber(case1);
        });

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            BonusNumber bonusNumber1 = new BonusNumber(case2);
        });

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            BonusNumber bonusNumber1 = new BonusNumber(case3);
        });
    }
}