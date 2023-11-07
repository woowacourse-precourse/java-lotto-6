package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BonusNumberTest {

    @Test
    void 보너스넘버_유효성검증() {
        assertThatThrownBy(() -> new BonusNumber(46)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BonusNumber(0)).isInstanceOf(IllegalArgumentException.class);
    }
}
