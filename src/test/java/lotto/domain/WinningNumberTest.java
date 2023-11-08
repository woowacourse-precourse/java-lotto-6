package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {
    WinningNumber winningNumber;

    @BeforeEach
    void createWinningNumber() {
        Lotto lotto = new Lotto((List.of(1, 2, 3, 4, 5, 6)));
        int bonusNumber = 7;

        winningNumber = new WinningNumber(lotto, bonusNumber);
    }

    @Test
    @DisplayName("사용자가 입력한 6개의 당첨 번호와 일치하는 개수를 구한다.")
    void calcMatchCount() {
        //given
        Lotto lotto = new Lotto((List.of(1, 2, 3, 7, 8, 9)));

        //when
        int matchCount = winningNumber.calcMatchCount(lotto);

        //then
        Assertions.assertEquals(3, matchCount);
    }

    @Test
    @DisplayName("보너스 번호와 일치하는 개수를 구한다.")
    void calcBonussMatchCount() {
        //given
        Lotto lotto = new Lotto((List.of(1, 2, 3, 7, 8, 9)));

        //where
        int matchCount = winningNumber.calcBonussMatchCount(lotto);

        //then
        Assertions.assertEquals(1, matchCount);
    }
}