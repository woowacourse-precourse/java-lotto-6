package lotto;

import Model.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberNotBetween1And45() {
        assertThatThrownBy(() -> new BonusNumber(60))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
