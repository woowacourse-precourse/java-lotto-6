package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {
    @DisplayName("입력값이 로또숫자의 범위인지 확인하는 로직의 예외처리")
    @ParameterizedTest
    @ValueSource(longs = {0, -3, 47})
    void 범위_예외처리(long number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("equals() 확인 기능")
    @ParameterizedTest
    @ValueSource(longs = {1, 4, 8, 45})
    void 동일_값_객체_확인(long number) {
        LottoNumber one = new LottoNumber(number);
        LottoNumber other = new LottoNumber(number);

        assertThat(one).isEqualTo(other);
    }

    @DisplayName("compareTo() 확인")
    @Test
    void 비교_기능() {
        LottoNumber one = new LottoNumber(1);
        LottoNumber two = new LottoNumber(2);

        assertThat(one.compareTo(two)).isEqualTo(-1);
    }

    @DisplayName("로또번호 문자 변환후 반환 기능")
    @Test
    void 로또번호_문자화() {
        LottoNumber lottoNumber = new LottoNumber(15);
        String expected = "15";

        assertThat(lottoNumber.getNumberMessage()).isEqualTo(expected);
    }
}
