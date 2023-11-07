package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {
    @DisplayName("당첨 번호 검증하기 ")
    @Test
    void validWinningNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        WinningNumber winningNumber = new WinningNumber(lotto, bonusNumber);

        assertAll(
                () -> assertEquals(lotto, winningNumber.getLotto()),
                () -> assertEquals(bonusNumber, winningNumber.getBonusNumber())
        );
    }
}