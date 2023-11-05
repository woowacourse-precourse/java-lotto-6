package domain;

import lotto.domain.WinningNumbers;
import lotto.domain.LottoErrorMessages;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static lotto.domain.LottoErrorMessages.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;

public class WinningNumberTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6: 7", "11,12,13,14,15,16: 17"}, delimiter = ':')
    @DisplayName("유효한 당첨 번호와 보너스 번호로 WinningNumbers 생성")
    void createWinningNumbers(String winningNumbers, int bonusNumber) {
        WinningNumbers result = WinningNumbers.of(winningNumbers, bonusNumber);

        assertThatCode(
                () -> WinningNumbers.of(winningNumbers, bonusNumber)).doesNotThrowAnyException();
        assertThat(result.getWinningLotto().getNumbers()).hasSize(6);
        assertThat(result.getBonusNumber().getNumber()).isEqualTo(bonusNumber);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6: 6", "11,12,13,14,15,16: 11"}, delimiter = ':')
    @DisplayName("보너스 번호가 당첨 번호 목록에 포함된 경우 예외 발생")
    void DuplicateBonusNumberTest(String winningNumbers, int bonusNumber) {
        assertThatThrownBy(() -> WinningNumbers.of(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_DUPLICATED.getMessage());
    }
}
