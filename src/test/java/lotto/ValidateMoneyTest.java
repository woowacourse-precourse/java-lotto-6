package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.validator.ValidateMoney;
import org.junit.jupiter.api.Test;

public class ValidateMoneyTest {

    @Test
    void 값이_천보다_큰지_검증() {
        assertThatThrownBy(() -> ValidateMoney.isOverThousand(999)).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 천원_단위인지_검증() {
        assertThatThrownBy(() -> ValidateMoney.isUnitFollowed(1234)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 너무_큰_값() {
        assertThatThrownBy(() -> ValidateMoney.isMoneyInRange(1000001)).isInstanceOf(IllegalArgumentException.class);
    }

}
