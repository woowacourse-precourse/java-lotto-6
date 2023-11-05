package lotto;

import lotto.domain.Bonus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {
    @DisplayName("보너스 번호가 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createBonusNotNumberic(){
        Assertions.assertThatThrownBy(() -> Bonus.from("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
