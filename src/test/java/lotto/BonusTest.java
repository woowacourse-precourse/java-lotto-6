package lotto;

import lotto.Model.Bonus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {

    @DisplayName("보너스 숫자가 숫자인지 테스트")
    @Test
    void isNumber() {
        Assertions.assertThatThrownBy(() -> new Bonus("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 숫자로만 입력해야 합니다.");
    }
}
