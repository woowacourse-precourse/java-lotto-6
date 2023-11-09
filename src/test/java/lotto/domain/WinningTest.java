package lotto.domain;

import lotto.exception.errorcode.InputErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.fixture.BonusFixture.당첨_번호에_포함되는_보너스_번호;
import static lotto.fixture.LottoFixture.SECOND;
import static lotto.fixture.LottoFixture.THIRD;
import static lotto.fixture.LottoFixture.WINNING;
import static lotto.fixture.WinningFixture.당첨_정보;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WinningTest {
    @DisplayName("당첨 번호에 보너스 번호가 포함되있는 경우 예외가 발생한다.")
    @Test
    public void createWinningLottoNumberContainBonusNumber() {
        assertThatThrownBy(() -> new Winning(WINNING.생성(), 당첨_번호에_포함되는_보너스_번호.생성()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputErrorCode.INCLUDE_BONUS_NUMBER_IN_WINNING_NUMBER.getMessage());
    }

    @DisplayName("일치하는 개수를 반환한다.")
    @Test
    public void getMatchedCount() throws Exception {
        final Winning winning = 당첨_정보.생성();
        final Lotto lotto = WINNING.생성();
        final int actual = winning.getMatchedCount(lotto);
        final int expect = 6;

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("보너스 숫자가 있는지 여부를 반환한다.")
    @Test
    public void getContainBonusNumber() throws Exception {
        final Winning winning = 당첨_정보.생성();
        final Lotto secondLotto = SECOND.생성();
        final Lotto thirdLotto = THIRD.생성();

        assertTrue(winning.containBonusNumber(secondLotto));
        assertFalse(winning.containBonusNumber(thirdLotto));
    }
}