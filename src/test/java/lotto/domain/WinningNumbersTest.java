package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersTest {

    @DisplayName("당첨 번호 생성시 예외 발생 메시지는 `로또 번호` 대신 `당첨 번호`가 포함되어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,46", "1,2,2,3,3,4"})
    void shouldContainsWinningNumberLiteralWhenException(String inputNumbers) {
        assertThatThrownBy(() -> new WinningNumbers(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("[ERROR]", "당첨 번호")
                .hasMessageNotContaining("로또 번호");
    }

    @DisplayName("보너스 번호 생성 시 당첨 번호와 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void throwsExceptionOnBonusNumberDuplicateWithWinningNumbers() {
        //given
        String winningNumber = "1,3,5,7,9,11";
        BonusNumber bonusNumber = new BonusNumber("11");

        //when
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber);

        //then
        assertThatThrownBy(() -> winningNumbers.setBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}