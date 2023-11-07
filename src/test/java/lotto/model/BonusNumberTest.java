package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @Test
    @DisplayName("보너스 번호가 잘 생성되는지 확인한다")
    void createBonusNumber() {
        BonusNumber bonusNumber = new BonusNumber(20);

        assertThat(bonusNumber.getBonusNumber()).isEqualTo(20);
    }

    @Test
    @DisplayName("1~45사이가 아닌 숫자를 입력 시 예외가 발생한다")
    void inputBonusNumberOutOfRange() {
        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자는 1에서 45 사이어야 합니다.");
    }

}
