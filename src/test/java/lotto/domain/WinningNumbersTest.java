package lotto.domain;

import java.util.Arrays;
import lotto.constant.TestConstant;
import lotto.domain.Lotto;
import lotto.domain.winningnumber.WinningNumbers;
import lotto.domain.winningnumber.WinningNumbersFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class WinningNumbersTest {

    @DisplayName("보너스 번호가 로또 번호에 포함되어 있지 않을 때, false를 반환한다")
    @Test
    void 보너스_번호_포함_안될때_false_반환() {
        String winningNumbersInput = "1, 2, 3, 4, 5, 6";
        int bonusNumber = 7;
        WinningNumbers winningNumbers = new WinningNumbers(winningNumbersInput, bonusNumber);

        Lotto lotto = new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13));

        boolean isBonusMatched = winningNumbers.matchBonus(lotto);

        Assertions.assertThat(isBonusMatched).isFalse();
    }

    @DisplayName("보너스 번호가 로또 번호에 포함되어 있을 때, true를 반환한다")
    @Test
    void 보너스_번호_포함_될때_true_반환() {
        String winningNumbersInput = "1, 2, 3, 4, 5, 6";
        int bonusNumber = 7;
        WinningNumbers winningNumbers = WinningNumbersFactory.createWinningNumbers(winningNumbersInput, bonusNumber);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));

        boolean isBonusMatched = winningNumbers.matchBonus(lotto);

        assertThat(isBonusMatched).isTrue();
    }


    @DisplayName("당첨 번호가 로또 번호에 포함되어 있는지 확인한다")
    @Test
    void 당첨_번호가_로또_번호에_포함_되는지() {
        String winningNumbersInput = "1, 2, 3, 4, 5, 6";
        WinningNumbers winningNumbers = WinningNumbersFactory.createWinningNumbers(winningNumbersInput, 10);

        assertThat(winningNumbers.contains(1)).isTrue();
        assertThat(winningNumbers.contains(4)).isTrue();
        assertThat(winningNumbers.contains(7)).isFalse();
    }

    @DisplayName("잘못된 형식의 당첨 번호 입력 시 예외가 발생한다.")
    @Test
    void 잘못된_당첨_번호_입력_시_예외_처리() {
        String invalidWinningNumbersInput = "1, 2, three, 4, 5, six";
        int bonusNumber = 7;

        assertThatThrownBy(() -> WinningNumbersFactory.createWinningNumbers(invalidWinningNumbersInput, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestConstant.ERROR_MESSAGE);
    }
}