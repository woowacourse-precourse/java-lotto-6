package lotto;

import lotto.domain.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("1~45 이외의 숫자로 보너스 번호를 생성하면 예외가 발생한다.")
    void createByInvalidRange() {
        int number = 46;

        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
