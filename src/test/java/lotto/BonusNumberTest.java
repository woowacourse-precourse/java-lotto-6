package lotto;

import lotto.domain.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @DisplayName("1~45 아닐 때 예외 발생")
    @Test
    void createBonusByIncorrectRangeNumber() {
        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다른 형식일때 예외 발생")
    @Test
    void createBonusByWrongFormatNumber() {
        assertThatThrownBy(() -> new BonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
