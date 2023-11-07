package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
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

    @DisplayName("보너스숫자 범위가 1-45가 벗어나면 예외처리 하기 ")
    @Test
    void validRangeBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 46;

        assertThatThrownBy(
                () -> new WinningNumber(lotto, bonus)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 안에 보너스숫자가 있으면 예외 처리하기")
    @Test
    void validDuplicateBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 6;

        assertThatThrownBy(
                () -> new WinningNumber(lotto, bonus)
        ).isInstanceOf(IllegalArgumentException.class);
    }


}