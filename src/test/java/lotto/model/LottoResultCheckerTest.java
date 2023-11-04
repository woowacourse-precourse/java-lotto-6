package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultCheckerTest {
    @DisplayName("당첨 번호와 중복된 보너스 번호 입력 시 예외가 발생한다.")
    @Test
    void testWhenBonusNumberDuplicateWinningNumbers() {
        LottoResultChecker lottoResultChecker = new LottoResultChecker("1,2,3,4,5,6");

        IllegalArgumentException bonusNumberError =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> lottoResultChecker.setBonusNumber("6"));
        assertThat(bonusNumberError.getMessage()).contains("[ERROR]");
    }

    @DisplayName("적절한 보너스 번호 입력 시 예외가 발생하지 않는다.")
    @Test
    void testWhenBonusNumberIsValid() {
        LottoResultChecker lottoResultChecker = new LottoResultChecker("1,2,3,4,5,6");

        Assertions.assertDoesNotThrow(() -> lottoResultChecker.setBonusNumber("20"));
    }
}
