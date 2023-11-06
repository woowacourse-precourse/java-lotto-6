package lotto;

import lotto.domain.BonusNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    @Test
    public void 보너스_숫자가_범위를_벗어났을_때_테스트() {
        int bonusNumber = 500;
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BonusNumber(bonusNumber));
    }

    @Test
    public void 유효한_보너스_숫자_테스트() {
        int bonusNumber = 7;
        Assertions.assertDoesNotThrow(() -> new BonusNumber(bonusNumber));
    }
}
