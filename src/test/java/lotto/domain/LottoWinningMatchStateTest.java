package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinningMatchStateTest {
    @Test
    @DisplayName("일치한 로또 숫자 개수가 음수라면 예외를 발생시킨다.")
    void calculateLottoMatchStateByNegativeCount() {
        assertThrows(IllegalArgumentException.class,
                () -> LottoWinningMatchState.calculateMatchState(-1));
    }

    @Test
    @DisplayName("일치한 로또 숫자 개수가 6개를 초과하면 예외를 발생시킨다.")
    void calculateLottoMatchStateByOverCount() {
        assertThrows(IllegalArgumentException.class,
                () -> LottoWinningMatchState.calculateMatchState(7));
    }
}
