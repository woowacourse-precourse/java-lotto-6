package lotto.model;

import lotto.exception.DuplicateBonusNumberException;
import lotto.exception.InvalidWinningLottoFormatException;
import lotto.exception.NonNumericBonusNumberException;
import lotto.exception.OutOfLottoNumberRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningsInitializerTest {
    private final WinningsInitializer winningsInitializer = new WinningsInitializer();

    @DisplayName("올바른 형식의 당첨 번호를 입력하면 예외가 발생하지 않는다.")
    @Test
    void inputWinningLottoCorrectly() {
        Lotto lotto = winningsInitializer.initWinningLotto("1,2,3,4,5,6");
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).isEqualTo(lottoNumbers);
    }

    @DisplayName("당첨 번호를 부족하게 입력하면 예외가 발생한다.")
    @Test
    void inputWinningLottoByIncomplete() {
        assertThatThrownBy(() -> winningsInitializer.initWinningLotto("1,2,3")).isInstanceOf(
                        IllegalArgumentException.class)
                .isInstanceOf(InvalidWinningLottoFormatException.class);
    }

    @DisplayName("당첨 번호가 쉼표로 끝나면 예외가 발생한다.")
    @Test
    void inputWinningLottoByEndingWithComma() {
        assertThatThrownBy(() -> winningsInitializer.initWinningLotto("1,2,3,4,5,6,")).isInstanceOf(
                        IllegalArgumentException.class)
                .isInstanceOf(InvalidWinningLottoFormatException.class);
    }

    @DisplayName("당첨 번호에 쉼표가 연달아있으면 예외가 발생한다.")
    @Test
    void inputWinningLottoByContainingRepeatedComma() {
        assertThatThrownBy(() -> winningsInitializer.initWinningLotto("1,2,3,,4,5,6")).isInstanceOf(
                        IllegalArgumentException.class)
                .isInstanceOf(InvalidWinningLottoFormatException.class);
    }

    @DisplayName("당첨 번호에 문자가 입력되면 예외가 발생한다.")
    @Test
    void inputWinningLottoByContainingCharacter() {
        assertThatThrownBy(() -> winningsInitializer.initWinningLotto("a,b,c,d,e,f")).isInstanceOf(
                        IllegalArgumentException.class)
                .isInstanceOf(InvalidWinningLottoFormatException.class);
    }

    @DisplayName("보너스 번호에 문자가 입력되면 예외가 발생한다.")
    @Test
    void inputBonusNumberByContainingCharacter() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> winningsInitializer.initBonusNumber("bonus", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .isInstanceOf(NonNumericBonusNumberException.class);
    }

    @DisplayName("보너스 번호가 로또 번호의 범위를 넘어가면 예외가 발생한다.")
    @Test
    void inputBonusNumberOutOfRange() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> winningsInitializer.initBonusNumber("0", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .isInstanceOf(OutOfLottoNumberRangeException.class);
    }

    @DisplayName("보너스 번호가 로또 번호에 포함되면 예외가 발생한다.")
    @Test
    void inputBonusNumberIncludedInWinningLotto() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> winningsInitializer.initBonusNumber("1", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .isInstanceOf(DuplicateBonusNumberException.class);
    }
}