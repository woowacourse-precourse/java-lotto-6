package lotto;

import lotto.domain.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @DisplayName("보너스 번호가 1과 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByRangeOutNumber() {
        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
