package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.DuplicateBonusNumberException;
import exception.InvalidWinningLottoFormatException;
import exception.NonNumericBonusNumberException;
import exception.OutOfLottoNumberRangeException;
import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InitializerTest {

    @DisplayName("당첨 번호를 부족하게 입력하면 예외가 발생한다.")
    @Test
    void inputWinningLottoByIncomplete() {
        Initializer initializer = new Initializer();
        assertThatThrownBy(() -> initializer.initWinningLotto("1,2,3")).isInstanceOf(
                        IllegalArgumentException.class)
                .isInstanceOf(InvalidWinningLottoFormatException.class);
    }

    @DisplayName("당첨 번호가 쉼표로 끝나면 예외가 발생한다.")
    @Test
    void inputWinningLottoByEndingWithComma() {
        Initializer initializer = new Initializer();
        assertThatThrownBy(() -> initializer.initWinningLotto("1,2,3,4,5,6,")).isInstanceOf(
                        IllegalArgumentException.class)
                .isInstanceOf(InvalidWinningLottoFormatException.class);
    }

    @DisplayName("당첨 번호에 쉼표가 연달아있으면 예외가 발생한다.")
    @Test
    void inputWinningLottoByContainingRepeatedComma() {
        Initializer initializer = new Initializer();
        assertThatThrownBy(() -> initializer.initWinningLotto("1,2,3,,4,5,6")).isInstanceOf(
                        IllegalArgumentException.class)
                .isInstanceOf(InvalidWinningLottoFormatException.class);
    }

    @DisplayName("당첨 번호에 문자가 입력되면 예외가 발생한다.")
    @Test
    void inputWinningLottoByContainingCharacter() {
        Initializer initializer = new Initializer();
        assertThatThrownBy(() -> initializer.initWinningLotto("a,b,c,d,e,f")).isInstanceOf(
                        IllegalArgumentException.class)
                .isInstanceOf(InvalidWinningLottoFormatException.class);
    }

    @DisplayName("보너스 번호에 문자가 입력되면 예외가 발생한다.")
    @Test
    void inputBonusNumberByContainingCharacter() {
        Initializer initializer = new Initializer();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> initializer.initBonusNumber("bonus", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .isInstanceOf(NonNumericBonusNumberException.class);
    }

    @DisplayName("보너스 번호가 로또 번호의 범위를 넘어가면 예외가 발생한다.")
    @Test
    void inputBonusNumberOutOfRange() {
        Initializer initializer = new Initializer();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> initializer.initBonusNumber("0", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .isInstanceOf(OutOfLottoNumberRangeException.class);
    }

    @DisplayName("보너스 번호가 로또 번호에 포함되면 예외가 발생한다.")
    @Test
    void inputBonusNumberIncludedInWinningLotto() {
        Initializer initializer = new Initializer();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> initializer.initBonusNumber("1", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .isInstanceOf(DuplicateBonusNumberException.class);
    }
}