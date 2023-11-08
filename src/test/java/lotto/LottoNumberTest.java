package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {
    @DisplayName("로또 번호의 범위가 1 이상 45 이하가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void meetsBound(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 숫자가 같다면 같은 값으로 판단한다.")
    @Test
    void compareByEqualNumber() {
        LottoNumber lottoNumber1 = new LottoNumber(6);
        LottoNumber lottoNumber2 = new LottoNumber(6);

        assertThat(lottoNumber1.equals(lottoNumber2)).isTrue();
    }

    @DisplayName("로또 번호의 숫자가 다르다면 다른 값으로 판단한다.")
    @Test
    void compareByNonEqualNumber() {
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(6);

        assertThat(lottoNumber1.equals(lottoNumber2)).isFalse();
    }
}