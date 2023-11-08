package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
    private static final int MIN_RANGE_NUMBER = 1;
    private static final int MAX_RANGE_NUMBER = 45;

    @ParameterizedTest
    @CsvSource(value = {"1,1", "45,45", "20,20"})
    void 범위내_숫자_입력시_객체_정상_생성(int input, int expected) {
        LottoNumber lottoNumber = LottoNumber.create(input);

        assertThat(lottoNumber.getNumber()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, -23})
    void 범위외_숫자_예외_처리(int input) {
        assertThatThrownBy(() -> LottoNumber.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("[ERROR] 로또 번호는 %d-%d 범위 내의 자연수여야 합니다.", MIN_RANGE_NUMBER, MAX_RANGE_NUMBER));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "45,45"})
    void number_같으면_equals_true_반환(int first, int second) {
        LottoNumber lottoOne = LottoNumber.create(first);
        LottoNumber lottoTwo = LottoNumber.create(second);
        assertThat(lottoOne.equals(lottoTwo)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,12", "43,45"})
    void number_다르면_equals_false_반환(int first, int second) {
        LottoNumber lottoOne = LottoNumber.create(first);
        LottoNumber lottoTwo = LottoNumber.create(second);
        assertThat(lottoOne.equals(lottoTwo)).isFalse();
    }
}