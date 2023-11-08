package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @DisplayName("1~45 범위 외의 숫자일 경우 예외 발생")
    @Test
    void 범위_외의_숫자일_경우_예외_발생() {
        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}