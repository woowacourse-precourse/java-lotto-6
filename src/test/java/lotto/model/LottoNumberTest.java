package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 넘버 정수 equals 테스트")
    public void equalsIntegerTest() {
        LottoNumber lottoNumber = new LottoNumber(7);
        assertThat(lottoNumber.equals(7)).isEqualTo(true);
    }

    @Test
    @DisplayName("로또 넘버 로또넘버와 equals 테스트(성공경우)")
    public void equalsLottoNumberTest() {
        LottoNumber lottoNumber1 = new LottoNumber(7);
        LottoNumber lottoNumber2 = new LottoNumber(7);
        assertThat(lottoNumber1.equals(lottoNumber2)).isEqualTo(true);
    }

    @Test
    @DisplayName("로또 넘버 로또넘버와 equals 테스트(실패경우)")
    public void equalsLottoNumberFalseTest() {
        LottoNumber lottoNumber1 = new LottoNumber(7);
        LottoNumber lottoNumber2 = new LottoNumber(8);
        assertThat(lottoNumber1.equals(lottoNumber2)).isEqualTo(false);
    }

    @ParameterizedTest
    @DisplayName("로또 넘버 숫자 범위 정상 테스트")
    @ValueSource(ints = {1,3,4,7,45})
    public void validateRangeNormalTest(Integer source) {
        assertThat(new LottoNumber(source)).isEqualTo(source);
    }

    @ParameterizedTest
    @DisplayName("로또 넘버 숫자 범위 예외 테스트")
    @ValueSource(ints = {-1,0,46})
    public void validateRangeExceptionTest(int source) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(Integer.valueOf(source));
        });
    }

}
