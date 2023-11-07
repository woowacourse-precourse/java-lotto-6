package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    @Test
    @DisplayName("보너스 번호가 1부터 45 사이의 숫자인지 검증한다.")
    void validateByRangeOfNumber() {
        assertThatThrownBy(() -> new BonusNumber("47"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
