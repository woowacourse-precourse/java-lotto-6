package lotto;

import lotto.domain.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
class BonusNumberTest {
        @DisplayName("보너스 번호가 로또 범위를 넘기면 예외가 발생한다.")
        @Test
        void BonusNumberOverRange() {
                assertThatThrownBy(() -> new BonusNumber(46))
                        .isInstanceOf(IllegalArgumentException.class);
        }
}
