package lotto.View;

import lotto.model.BonusNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    @DisplayName("보너스 숫자의 범위가 1이상 45이하일 때")
    @Test
    void bonusNumberInRangeTest() {
        BonusNumber bonusNumber1 = new BonusNumber(1);
        BonusNumber bonusNumber2 = new BonusNumber(45);

        Assertions.assertThat(bonusNumber1.getBonusNumber()).isEqualTo(1);
        Assertions.assertThat(bonusNumber2.getBonusNumber()).isEqualTo(45);
    }
}
