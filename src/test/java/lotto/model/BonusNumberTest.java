package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

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

}
