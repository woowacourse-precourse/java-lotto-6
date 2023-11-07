package lotto;

import lotto.domain.Bonus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {
    @DisplayName("보너스 번호가 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createBonusNotNumberic() {
        Assertions.assertThatThrownBy(() -> Bonus.from("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1미만의 숫자를 입력받았다면 예외가 발생한다.")
    @Test
    void createBonusLowerThanMinimumRange() {
        Assertions.assertThatThrownBy(() -> Bonus.from("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 45를 초과하는 숫자를 입력받았다면 예외가 발생한다.")
    @Test
    void createBonusByOverRange() {
        Assertions.assertThatThrownBy(() -> Bonus.from("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
