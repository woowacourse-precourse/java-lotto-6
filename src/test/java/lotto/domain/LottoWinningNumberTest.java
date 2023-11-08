package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningNumberTest {
    @Test
    @DisplayName("당첨 번호가 유효 범위를 벗어날 경우 예외 발생")
    void 당첨_번호가_유효_범위를_벗어날_경우_예외_발생() {
        LottoWinningNumber winningNumber = new LottoWinningNumber();
        assertThrows(IllegalArgumentException.class, () -> winningNumber.setWinningNumbers(Arrays.asList(0, 46)));
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외 발생")
    void 보너스_번호가_당첨_번호와_중복될_경우_예외_발생() {
        LottoWinningNumber winningNumber = new LottoWinningNumber();
        winningNumber.setWinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThrows(IllegalArgumentException.class, () -> winningNumber.setBonusNumber(6));
    }
}