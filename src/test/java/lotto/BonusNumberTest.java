package lotto;

import lotto.domain.lotto.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @Test
    @DisplayName("보너스 번호는 1-45 사이의 숫자를 가져야 한다.")
    void createBonusNumber_Number_throwsIllegalArgumentException() {
        // given
        int bonusNumber = 46;

        // when & then
        assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
