package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    void 로또번호_만드는_기능() {
        // given
        LottoNumber lottoNumber = LottoNumber.newInstance("1");
        LottoNumber lottoNumber2 = LottoNumber.newInstance("45");

        // when

        // then
        assertThat(lottoNumber).isInstanceOf(LottoNumber.class);
        assertThat(lottoNumber2).isInstanceOf(LottoNumber.class);
    }

    @Test
    void 로또번호_일치_기능() {
        // given
        LottoNumber lottoNumber = LottoNumber.newInstance("3");
        // when

        // then
        assertThat(lottoNumber.isSame(3)).isTrue();
    }

    @Test
    void 로또번호가_공백이면_예외발생() {
        assertThatThrownBy(() -> LottoNumber.newInstance(" ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumber.newInstance("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호_사이에_공백이면_예외발생() {
        assertThatThrownBy(() -> LottoNumber.newInstance("2 3")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호가_숫자가_아니면_예외발생() {
        assertThatThrownBy(() -> LottoNumber.newInstance("2a")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumber.newInstance("ab")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumber.newInstance("222a33")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호가_범위를_벗어나면_예외발생() {
        assertThatThrownBy(() -> LottoNumber.newInstance("0")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumber.newInstance("-1")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumber.newInstance("46")).isInstanceOf(IllegalArgumentException.class);
    }



}