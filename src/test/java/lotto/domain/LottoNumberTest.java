package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {
    @DisplayName("로또 숫자 객체 생성을 테스트한다.")
    @Test
    void createLottoNumberByValidNumber() {
        LottoNumber lottoNumber = LottoNumber.getInstance(1);
        assertThat(lottoNumber).isNotNull();
    }

    @DisplayName("로또 번호가 범위인 1 ~ 45가 아니라면 예외가 발생한다.")
    @Test
    void createLottoNumberByOverRange() {
        assertThatThrownBy(() -> LottoNumber.getInstance(70))
                .isInstanceOf(IllegalArgumentException.class);
    }
}