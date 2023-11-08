package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("로또 번호 생성 테스트")
    @Test
    void createTest() {
        // given
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(45);

        // when, then
        assertThat(lottoNumber1).isEqualTo(new LottoNumber(1));
        assertThat(lottoNumber2).isEqualTo(new LottoNumber(45));
    }

    @DisplayName("로또 번호 유효성 검사 테스트")
    @Test
    void numberValidationTest() {
        assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 비교 테스트")
    @ParameterizedTest
    @MethodSource("numberCompareInputProvider")
    public void numberCompareTest(int me, int other, int expected) {
        // given
        LottoNumber lottoNumber1 = new LottoNumber(me);
        LottoNumber lottoNumber2 = new LottoNumber(other);

        // when
        int result = lottoNumber1.compareTo(lottoNumber2);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> numberCompareInputProvider() {
        return Stream.of(
                Arguments.of(3, 4, -1),
                Arguments.of(4, 3, 1),
                Arguments.of(3, 6, -3),
                Arguments.of(6, 3, 3),
                Arguments.of(3, 3, 0)
        );
    }
}
