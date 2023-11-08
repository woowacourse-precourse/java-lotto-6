package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    @Test
    @DisplayName("정상 작동 케이스")
    public void testBonusNumberByValidInput() {
        String bonus = "10";
        BonusNumber bonusNumber = new BonusNumber(bonus);

        assertThat(bonusNumber).isNotNull();
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(Integer.parseInt(bonus));
    }

    @Test
    @DisplayName("보너스 번호가 45보다 큰 숫자가 들어오면 예외 발생")
    public void testBonusNumberByAboveRange() {
        String bonus = "50";
        assertThatThrownBy(() -> new BonusNumber(bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

}
