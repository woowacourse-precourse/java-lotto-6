package domain;

import lotto.domin.Bonus;
import lotto.view.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusTest {

    @DisplayName("보너스 값과 6개의 로또값중 중복이 있을 경우")
    @Test
    public void BonusTest() {
        String bonus = "7";
        List<Integer> selectBonus = List.of(1, 2, 4, 5, 6, 7);
        assertThatThrownBy(() -> new Bonus(bonus, selectBonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_NUMBER_OVERLAP.getExceptionValue());
    }

    @DisplayName("보너스 값 유효성 검사 성공")
    @Test
    public void BonusTest2() {
        String bonus = "12";
        List<Integer> selectBonus = List.of(1, 2, 4, 5, 6, 7);
        Bonus bonusNumber = new Bonus(bonus, selectBonus);
        assertThat(bonusNumber.getBonus()).isEqualTo(12);
    }



}