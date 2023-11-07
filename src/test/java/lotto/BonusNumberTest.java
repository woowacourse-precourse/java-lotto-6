package lotto;

import java.util.Arrays;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    @Test
    public void 보너스_숫자가_범위를_벗어났을_때_테스트() {
        int bonusNumber = 500;
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BonusNumber(bonusNumber, winningNumbers));
    }

    @Test
    public void 보너스_숫자가_당첨번호와_중복되는_경우_테스트() {
        int bonusNumber = 27;
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 27));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BonusNumber(bonusNumber, winningNumbers));
    }

    @Test
    public void 유효한_보너스_숫자_테스트() {
        int bonusNumber = 7;
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Assertions.assertDoesNotThrow(() -> new BonusNumber(bonusNumber, winningNumbers));
    }
}
