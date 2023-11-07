package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {

    @DisplayName("객체 생성 및 get 메서드 테스트")
    @Test
    void createTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        WinningNumber winningNumber = new WinningNumber(lotto, bonusNumber);
        assertNotNull(winningNumber);
        assertEquals(lotto, winningNumber.getLotto());
        assertEquals(bonusNumber, winningNumber.getBonusNumber());
    }

}