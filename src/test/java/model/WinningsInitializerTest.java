package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.DuplicateBonusNumberException;
import lotto.exception.InvalidWinningLottoFormatException;
import lotto.exception.NonNumericBonusNumberException;
import lotto.exception.OutOfLottoNumberRangeException;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningsInitializer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningsInitializerTest {

    @DisplayName("당첨 번호를 부족하게 입력하면 예외가 발생한다.")
    @Test
    void inputWinningLottoByIncomplete() {
        WinningsInitializer winningsInitializer = new WinningsInitializer();
        assertThatThrownBy(() -> winningsInitializer.initWinningLotto("1,2,3")).isInstanceOf(
                        IllegalArgumentException.class)
                .isInstanceOf(InvalidWinningLottoFormatException.class);
    }

    @DisplayName("당첨 번호가 쉼표로 끝나면 예외가 발생한다.")
    @Test
    void inputWinningLottoByEndingWithComma() {
        WinningsInitializer winningsInitializer = new WinningsInitializer();
        assertThatThrownBy(() -> winningsInitializer.initWinningLotto("1,2,3,4,5,6,")).isInstanceOf(
                        IllegalArgumentException.class)
                .isInstanceOf(InvalidWinningLottoFormatException.class);
    }

    @DisplayName("당첨 번호에 쉼표가 연달아있으면 예외가 발생한다.")
    @Test
    void inputWinningLottoByContainingRepeatedComma() {
        WinningsInitializer winningsInitializer = new WinningsInitializer();
        assertThatThrownBy(() -> winningsInitializer.initWinningLotto("1,2,3,,4,5,6")).isInstanceOf(
                        IllegalArgumentException.class)
                .isInstanceOf(InvalidWinningLottoFormatException.class);
    }

    @DisplayName("당첨 번호에 문자가 입력되면 예외가 발생한다.")
    @Test
    void inputWinningLottoByContainingCharacter() {
        WinningsInitializer winningsInitializer = new WinningsInitializer();
        assertThatThrownBy(() -> winningsInitializer.initWinningLotto("a,b,c,d,e,f")).isInstanceOf(
                        IllegalArgumentException.class)
                .isInstanceOf(InvalidWinningLottoFormatException.class);
    }

    @DisplayName("보너스 번호에 문자가 입력되면 예외가 발생한다.")
    @Test
    void inputBonusNumberByContainingCharacter() {
        WinningsInitializer winningsInitializer = new WinningsInitializer();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> winningsInitializer.initBonusNumber("bonus", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .isInstanceOf(NonNumericBonusNumberException.class);
    }

    @DisplayName("보너스 번호가 로또 번호의 범위를 넘어가면 예외가 발생한다.")
    @Test
    void inputBonusNumberOutOfRange() {
        WinningsInitializer winningsInitializer = new WinningsInitializer();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> winningsInitializer.initBonusNumber("0", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .isInstanceOf(OutOfLottoNumberRangeException.class);
    }

    @DisplayName("보너스 번호가 로또 번호에 포함되면 예외가 발생한다.")
    @Test
    void inputBonusNumberIncludedInWinningLotto() {
        WinningsInitializer winningsInitializer = new WinningsInitializer();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> winningsInitializer.initBonusNumber("1", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .isInstanceOf(DuplicateBonusNumberException.class);
    }
}