package lotto.model.lotto;

import static lotto.fixture.LottoFixture.createBonusBall;
import static lotto.fixture.LottoFixture.createLotto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.common.exception.ErrorMessage;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WinningTicketTest {
    @Nested
    class 당첨로또_생성 {
        @Test
        void 당첨로또가_생성된다() {
            //given
            Lotto lotto = createLotto(1, 2, 3, 4, 5, 6);
            BonusBall bonusBall = createBonusBall(10);
            //when
            WinningTicket winningTicket = new WinningTicket(lotto, bonusBall);
            //then
            assertThat(winningTicket.lotto()).isEqualTo(lotto);
            assertThat(winningTicket.bonusBall()).isEqualTo(bonusBall);
        }

        @Test
        void 보너스볼번호와_당첨로또번호간_중복이있다면_예외가발생한다() {
            //given
            Lotto lotto = createLotto(1, 2, 3, 4, 5, 6);
            BonusBall bonusBall = createBonusBall(5);
            //when then
            assertThatThrownBy(() -> new WinningTicket(lotto, bonusBall))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining(ErrorMessage.DUPLICATED_WINNING_LOTTO_NUMBER_AND_BONUS_BALL.getValue());
        }
    }
}