package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        LottoNumber number = LottoNumber.from(1);
        LottoNumber other = LottoNumber.from(1);

        assertThat(number).isEqualTo(other);
    }

    @DisplayName("알 수 없는 번호로 로또 번호를 생성할 수 없다.")
    @Test
    void checkNumberNonNull() {
        assertThatThrownBy(() -> LottoNumber.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 숫자로 로또 번호를 생성할 수 없습니다.");
    }

    @DisplayName("로또 번호는 1보다 크거나 같아야 한다.")
    @Test
    void checkInsufficient() {
        assertThatThrownBy(() -> LottoNumber.from(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호는 45보다 작거나 같아야 한다.")
    @Test
    void checkExceed() {
        assertThatThrownBy(() -> LottoNumber.from(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
