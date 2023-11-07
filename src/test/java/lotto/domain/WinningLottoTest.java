package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.TestConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class WinningLottoTest {
    private final static Lotto lotto = new Lotto(TestConstant.NORMAL_NUMBERS);

    private WinningLotto winningLotto;

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void setBonusNumberByDuplicatedNumbers() {
        createWinningLottoByNumbers(TestConstant.NORMAL_NUMBERS);

        assertThatThrownBy(() -> winningLotto.setBonusNumber(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호를 여러 번 할당 하려고 하면 예외가 발생한다.")
    @Test
    void setBonusNumberMultipleTimes() {
        createWinningLottoByNumbers(TestConstant.NORMAL_NUMBERS);
        winningLotto.setBonusNumber(45);

        assertThatThrownBy(() -> winningLotto.setBonusNumber(45))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("보너스 번호를 할당한다.")
    @Test
    void setBonusNumber() {
        createWinningLottoByNumbers(TestConstant.NORMAL_NUMBERS);
        winningLotto.setBonusNumber(45);
    }

    @DisplayName("보너스 번호를 맞췄는지 확인한다. - 맞춘 경우")
    @Test
    void isMatchedBonusBallWhenIsMatched() {
        createWinningLottoByNumbers(List.of(1,2,3,4,5,7));
        winningLotto.setBonusNumber(6);

        boolean bonusNumberMatched = winningLotto.isMatchedBonusNumber(lotto);

        assertThat(bonusNumberMatched).isEqualTo(true);
    }

    @DisplayName("보너스 번호를 맞췄는지 확인한다. - 못 맞춘 경우")
    @Test
    void isMatchedBonusBallWhenIsNotMatched() {
        createWinningLottoByNumbers(TestConstant.NORMAL_NUMBERS);
        winningLotto.setBonusNumber(7);

        boolean bonusNumberMatched = winningLotto.isMatchedBonusNumber(lotto);

        assertThat(bonusNumberMatched).isEqualTo(false);
    }

    private void createWinningLottoByNumbers(List<Integer> numbers) {
        winningLotto = new WinningLotto(numbers);
    }
}