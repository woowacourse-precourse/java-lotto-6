package lotto.domain;

import lotto.exception.ErrorStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("보너스 번호를 반환한다.")
    @Test
    void getBonusNumber() {
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        BonusBall bonusBall = new BonusBall(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusBall);

        //when
        int bonusNumber = winningLotto.getBonusNumber();

        //then
        assertThat(bonusNumber).isEqualTo(bonusBall.getBonusNumber());
    }

    @DisplayName("로또 번호와 당첨 번호가 일치하는 개수를 반환한다.")
    @Test
    void matchCount() {
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        BonusBall bonusBall = new BonusBall(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusBall);
        Lotto targetLotto = new Lotto(List.of(1,2,3,4,5,7));

        //when
        int matchCount = winningLotto.matchCount(targetLotto);

        //then
        assertThat(matchCount).isEqualTo(5);
    }

    @DisplayName("보너스 번호와 일치하는지 확인한다.")
    @Test
    void isMatchBonusNumber() {
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        BonusBall bonusBall = new BonusBall(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusBall);
        Lotto targetLotto = new Lotto(List.of(1,2,3,4,5,7));

        //when
        boolean matchBonusNumber = winningLotto.isMatchBonusNumber(targetLotto);

        //then
        assertThat(matchBonusNumber).isTrue();
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복하면 예외를 발생시킨다.")
    @Test
    void createWinningLottoByDuplicatedNumber() {
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        BonusBall bonusBall = new BonusBall(6);

        //when
        //then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusBall))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorStatus.BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
    }

}