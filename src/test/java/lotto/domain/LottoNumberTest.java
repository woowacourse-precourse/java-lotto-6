package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또를 이루는 번호 테스트")
class LottoNumberTest {

    @DisplayName("1-45의 범위를 지키는 수는 검증을 통과한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 44, 45})
    void testInRangeLottoNumberValidation(int number) {
        assertThatNoException().isThrownBy(() -> LottoNumber.from(number));
    }

    @DisplayName("1-45의 범위를 지키지 않는 수는 검증에 실패한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void testOutOfRangeLottoNumberValidation(int number) {
        assertThatThrownBy(() -> LottoNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getErrorMessage());
    }

    @DisplayName("동일 값의 로또 자릿 수는 서로 동등하다")
    @Test
    void testEqualsWithSameValues() {
        LottoNumber lottoNumber1 = LottoNumber.from(5);
        LottoNumber lottoNumber2 = LottoNumber.from(5);
        assertThat(lottoNumber1).isEqualTo(lottoNumber2);
    }

    @DisplayName("값이 다른 로또 자릿 수는 동등하지 않다")
    @Test
    void testEqualsWithDifferentValues() {
        LottoNumber lottoNumber1 = LottoNumber.from(5);
        LottoNumber lottoNumber2 = LottoNumber.from(7);
        assertThat(lottoNumber1).isNotEqualTo(lottoNumber2);
    }

    @DisplayName("동일한 값의 로또 자리수는 해시 코드가 동일하다")
    @Test
    void testHashCodeWithSameValues() {
        LottoNumber lottoNumber1 = LottoNumber.from(5);
        LottoNumber lottoNumber2 = LottoNumber.from(5);
        assertThat(lottoNumber1).isEqualTo(lottoNumber2);
    }

    @DisplayName("다른 값의 로또 자리수는 해시 코드가 다르게 생성된다")
    @Test
    void testHashCodeWithDifferentValues() {
        LottoNumber lottoNumber1 = LottoNumber.from(5);
        LottoNumber lottoNumber2 = LottoNumber.from(7);
        assertThat(lottoNumber1).isNotEqualTo(lottoNumber2);
    }
}