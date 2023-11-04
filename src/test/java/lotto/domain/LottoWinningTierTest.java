package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinningTierTest {
    @Test
    @DisplayName("일치한 로또 숫자 개수가 음수라면 예외를 발생시킨다.")
    void calculateLottoWinningTierByNegativeCount() {
        assertThrows(IllegalArgumentException.class, () -> LottoWinningTier.calculateTier(-1, false));
    }

    @Test
    @DisplayName("일치한 로또 숫자 개수가 6개를 초과하면 예외를 발생시킨다.")
    void calculateLottoWinningTierByOverCount() {
        assertThrows(IllegalArgumentException.class, () -> LottoWinningTier.calculateTier(7, false));
    }
}
