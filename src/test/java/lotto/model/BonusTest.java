package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.util.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BonusTest {
    Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 보너스_번호의_범위가_적절한지_검증() {
        assertThatThrownBy(() -> new Bonus(46, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_RANGE.getMessage());
    }

    @Test
    void 보너스_번호가_당첨번호에_포함되는지_검증() {
        assertThatThrownBy(() -> new Bonus(6, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATED_BONUS.getMessage());
    }
}
