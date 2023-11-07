package lotto;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @Test
    void 당첨번호_만드는_기능() {
        // given
        WinningNumber winningNumber = WinningNumber.newInstance("1,2,3,4,5,6");
        // when

        // then
        assertThat(winningNumber).isInstanceOf(WinningNumber.class);
    }

    @Test
    void 특정_숫자가_있는지_확인() {
        // given
        WinningNumber winningNumber = WinningNumber.newInstance("1,2,3,4,5,6");
        // when
        boolean trueValue = winningNumber.hasNumber(3);
        boolean falseValue = winningNumber.hasNumber(7);
        // then
        assertThat(trueValue).isTrue();
        assertThat(falseValue).isFalse();
    }

    @Test
    void 특정_로또번호가_중복되면_예외발생() {
        // given
        WinningNumber winningNumber = WinningNumber.newInstance("1,2,3,4,5,6");
        LottoNumber lottoNumber = LottoNumber.newInstance("7");
        LottoNumber lottoNumber2 = LottoNumber.newInstance("3");

        // when
        winningNumber.hasNumber(lottoNumber);
        // then
        assertThatThrownBy(() -> winningNumber.hasNumber(lottoNumber2)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복이면_예외발생() {
        assertThatThrownBy(() -> WinningNumber.newInstance("1,1,3,4,5,6")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 콤마로_시작하거나_끝나면_예외발생() {
        assertThatThrownBy(() -> WinningNumber.newInstance("1,2,3,4,5,6,")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> WinningNumber.newInstance(",1,2,3,4,5,6")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> WinningNumber.newInstance(",1,2,3,4,5,6,")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백이면_예외발생() {
        assertThatThrownBy(() -> WinningNumber.newInstance("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> WinningNumber.newInstance(" ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 개수가_6개_이상이면_예외발생() {
        assertThatThrownBy(() -> WinningNumber.newInstance("1,2,3,4,5,6,7")).isInstanceOf(IllegalArgumentException.class);
    }

}