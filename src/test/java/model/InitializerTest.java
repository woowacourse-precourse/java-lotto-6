package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.InvalidWinningLottoFormatException;
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
}