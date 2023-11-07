package lotto;

import lotto.domain.winningnumber.WinningNumbers;
import lotto.domain.winningnumber.WinningNumbersFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersFactoryTest {

    @DisplayName("정상적인 입력으로 당첨 번호 인스턴스를 생성한다.")
    @Test
    void 정상_입력으로_당첨번호_인스턴스_생성() {
        String winningNumbersInput = "1, 2, 3, 4, 5, 6";
        int bonusNumber = 7;

        WinningNumbers winningNumbers = WinningNumbersFactory.createWinningNumbers(winningNumbersInput, bonusNumber);

        assertThat(winningNumbers).isNotNull();
        assertThat(winningNumbers.contains(1)).isTrue();
        assertThat(winningNumbers.contains(7)).isFalse();
    }

    @DisplayName("잘못된 형식의 입력이 들어올 경우 예외가 발생한다.")
    @Test
    void 잘못된_형식의_입력으로_예외_발생() {
        String invalidWinningNumbersInput = "1, two, 3, 4, 5, six";
        int bonusNumber = 7;

        assertThatThrownBy(() -> WinningNumbersFactory.createWinningNumbers(invalidWinningNumbersInput, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestConstant.ERROR_MESSAGE);
    }
}
