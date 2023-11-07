package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {
    @DisplayName("로또 번호는 중복되지 않아야한다")
    @Test
    void lottoNumberNotDuplicated() {
        assertThatThrownBy(() -> new LottoNumber(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 1~45 사이의 숫자여야 한다.")
    @Test
    void lottoNumberRange() {
        assertThatThrownBy(() -> new LottoNumber(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("매개 변수로 받은 로또 번호와 일치하는 번호의 개수를 반환한다.")
    @Test
    void matchNumbers() {
        LottoNumber lottoNumber = new LottoNumber(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumber.matchNumbers(new LottoNumber(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
    }

    @DisplayName("보너스 번호를 포함하고 있지 않으면 false를 반환한다.")
    @Test
    void containsBonusNumber() {
        LottoNumber lottoNumber = new LottoNumber(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumber.containsBonusNumber(7)).isFalse();
    }

    @DisplayName("보너스 번호를 포함하고 있으면 true를 반환한다.")
    @Test
    void containsBonusNumber2() {
        LottoNumber lottoNumber = new LottoNumber(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumber.containsBonusNumber(6)).isTrue();
    }

    @DisplayName("로또 번호를 문자열로 반환한다.")
    @Test
    void toStringTest() {
        LottoNumber lottoNumber = new LottoNumber(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumber.toString()).isEqualTo("1, 2, 3, 4, 5, 6");
    }
}