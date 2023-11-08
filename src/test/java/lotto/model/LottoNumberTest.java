package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void 로또_번호는_유효한_범위_값으로_생성되면_예외가_발생하지_않는다(int number) {
        assertDoesNotThrow(() -> LottoNumber.from(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또_번호는_유효한_범위_값으로_생성되지_않으면_예외가_발생한다(int number) {
        assertThatThrownBy(() -> LottoNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 번호가_같은_로또_번호는_캐싱된_객체이다() {
        LottoNumber firstInstance = LottoNumber.from(1);
        LottoNumber secondInstance = LottoNumber.from(1);

        assertThat(firstInstance).isSameAs(secondInstance);
    }

    @Test
    void 번호가_같은_로또_번호는_같은_객체이다() {
        LottoNumber actualLottoNumber = LottoNumber.from(1);
        LottoNumber expectedLottoNumber = LottoNumber.from(1);

        assertThat(actualLottoNumber).isEqualTo(expectedLottoNumber);
    }

    @Test
    void 번호가_다른_로또_번호는_다른_객체이다() {
        LottoNumber actualLottoNumber = LottoNumber.from(1);
        LottoNumber expectedLottoNumber = LottoNumber.from(2);

        assertThat(actualLottoNumber).isNotEqualTo(expectedLottoNumber);
    }

    @Test
    void 번호가_같은_로또_번호는_같은_해시코드를_가진다() {
        LottoNumber actualLottoNumber = LottoNumber.from(1);
        LottoNumber expectedLottoNumber = LottoNumber.from(1);

        assertThat(actualLottoNumber).hasSameHashCodeAs(expectedLottoNumber);
    }
}
