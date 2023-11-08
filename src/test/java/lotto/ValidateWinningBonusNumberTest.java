package lotto;

import lotto.util.ValidateNumber;
import lotto.util.ValidateWinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidateWinningBonusNumberTest {

    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createWinningBonusNumberByNotRange() {
        Assertions.assertThatThrownBy(() -> ValidateWinningNumber.validateBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
