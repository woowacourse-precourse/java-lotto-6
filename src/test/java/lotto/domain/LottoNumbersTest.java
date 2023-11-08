package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumbersTest {

    @Test
    void 로또_번호를_입력할_수_있다() {
        // given
        LottoNumbers lottoNumbers = new LottoNumbers("1,2,3,4,5,6");

        // then
        Assertions.assertThat(lottoNumbers).isEqualTo(new LottoNumbers("1,2,3,4,5,6"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "0,1,2,3,4,5", "a, 1, 2, 3, 4, 5", "1,1,1,1,1,1"})
    void 입력이_잘못되면_예외가_발생한다(String lottoNumber) {
        // when
        Assertions.assertThatThrownBy(() -> new LottoNumbers(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
