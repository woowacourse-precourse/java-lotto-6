package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @Test
    @DisplayName("보너스 번호가 잘 생성되는지 확인한다")
    void createBonusNumber() {
        BonusNumber bonusNumber = new BonusNumber(20);

        assertThat(bonusNumber.getBonusNumber()).isEqualTo(20);
    }

}
