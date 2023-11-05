package lotto.domain;

import static lotto.constant.ErrorMessage.OUT_OF_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    @DisplayName("1~45 범위가 아닐경우")
    @Test
    void 보너스_번호_범위_45보다_큰_경우() {
        int invalidNumber = 46;
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new BonusNumber(invalidNumber));
        assertThat(exception.getMessage()).isEqualTo(OUT_OF_NUMBER_RANGE.getMessage());
    }

    @Test
    void 보너스_번호_범위_1보다_작은_경우() {
        int invalidNumber = 0;
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new BonusNumber(invalidNumber));
        assertThat(exception.getMessage()).isEqualTo(OUT_OF_NUMBER_RANGE.getMessage());
    }

}
