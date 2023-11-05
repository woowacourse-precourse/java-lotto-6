package lotto;

import lotto.domain.model.Bonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.constant.ErrorConst.BONUS_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BonusTest {

    @Test
    @DisplayName("보너스 번호가 45보다 크면 예외가 발생한다")
    void createBonusBiggerThanMaximumNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Bonus(46);
        }).withMessage(BONUS_OUT_OF_RANGE);
    }

    @Test
    @DisplayName("보너스 번호가 1보다 작으면 예외가 발생한다")
    void createBonusLowerThanMinimumNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Bonus(0);
        }).withMessage(BONUS_OUT_OF_RANGE);
    }

    @Test
    @DisplayName("모든 검증을 통과하면 보너스 번호가 생성된다")
    void createBonusSuccessfully() {
        Bonus bonus = new Bonus(5);
        assertThat(bonus).isNotNull();

        int number = bonus.getNumber();
        assertThat(number).isEqualTo(5);
    }

}
