package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
