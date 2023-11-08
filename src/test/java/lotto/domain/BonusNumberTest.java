package lotto.domain;

import static lotto.utils.ErrorMessages.BONUS_NUMBER_DUPLICATE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("BonusNumber 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BonusNumberTest {

    @ParameterizedTest
    @CsvSource(value = {"1:1,2,3,4,5,6", "17:12,14,23,17,44,43"}, delimiter = ':')
    void 생성자는_보너스_번호가_당첨번호와_중복되면_예외를_던진다(int bonusNumber, String winningNumbers) {
        WinningNumbers testWinningNumbers = new WinningNumbers(winningNumbers);

        Assertions.assertThatThrownBy(() -> new BonusNumber(bonusNumber, testWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_DUPLICATE);
    }

    @ParameterizedTest
    @CsvSource(value = {"7:1,2,3,4,5,6", "45:12,14,23,17,44,43"}, delimiter = ':')
    void 생성자는_보너스_번호와_당첨번호가_중복되지_않으면_객체를_생성한다(int bonusNumber, String winningNumbers) {
        WinningNumbers testWinningNumbers = new WinningNumbers(winningNumbers);
        BonusNumber testBonusNumber = new BonusNumber(bonusNumber, testWinningNumbers);

        assertEquals(testBonusNumber.isEquals(new LottoNumber(bonusNumber)), true);
    }
}
