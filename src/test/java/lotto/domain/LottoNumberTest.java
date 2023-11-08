package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46, 100})
    public void 로또_숫자가_1과_45_사이의_값이_아니면_예외를_발생시킨다(int number) {
        // when, then
        Assertions.assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 30, 45})
    public void 로또_숫자가_1과_45_사이의_값이면_LottoNumber_객체를_생성할_수_있다(int number) {
        // when
        LottoNumber lottoNumber = new LottoNumber(number);

        // then
        Assertions.assertThat(lottoNumber).isNotNull();
    }
}