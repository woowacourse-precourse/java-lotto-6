package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void 로또_번호는_유효한_범위_값으로만_가능하다(int number) {
        assertDoesNotThrow(() -> LottoNumber.from(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또_번호는_유효한_범위_값이_아니면_생성되지_않는다(int number) {
        assertThrows(IllegalArgumentException.class, () -> LottoNumber.from(number));
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
