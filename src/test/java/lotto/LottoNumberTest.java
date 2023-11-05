package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @DisplayName("0 이하의 로또 숫자를 생성했을 때 에러가 반환된다.")
    @Test
    void createNumberUnderMinimum() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("45 이상의 로또 숫자를 생성했을 때 에러가 반환된다.")
    @Test
    void createNumberOverMaximum() {
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
