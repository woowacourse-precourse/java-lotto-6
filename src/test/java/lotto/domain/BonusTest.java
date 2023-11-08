package lotto.domain;

import lotto.exception.errorcode.InputErrorCode;
import lotto.fixture.LottoFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.fixture.BonusFixture.당첨_보너스_번호;
import static lotto.fixture.BonusFixture.범위를_벗어난_보너스_번호;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BonusTest {
    @DisplayName("보너스 번호가 1 ~ 45 범위가 벗어나면 예외가 발생한다.")
    @Test
    public void createBonusNumberInvalidRange() throws Exception {
        assertThatThrownBy(() -> 범위를_벗어난_보너스_번호.생성())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputErrorCode.INVALID_BONUS_NUMBER_RANGE.getMessage());
    }

    @DisplayName("로또에 보너스 번호가 되있는지 여부를 반환")
    @Test
    public void containBonusNumberFromLotto() throws Exception {
        final Bonus bonus = 당첨_보너스_번호.생성();
        final Lotto secondLotto = LottoFixture.SECOND.생성();
        assertTrue(bonus.containNumber(secondLotto));
    }
}