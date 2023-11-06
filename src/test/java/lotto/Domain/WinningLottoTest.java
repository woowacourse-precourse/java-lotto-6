package lotto.Domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있는 숫자라면 예외가 발생한다.")
    @Test
    void createWinningLottoByWinningNumbersIncludeBonusNumber() {
        Assertions.assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(6)))
                .isInstanceOf(
                        IllegalArgumentException.class);
    }

    @DisplayName("로또번호가 당첨번호와 모두 일치한다면 1등을 반한한다.")
    @Test
    void returnFirstRankWhenHitSix() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        Assertions.assertThat(winningLotto.getRankOf(lotto)).isEqualTo(Rank.FIRST);
    }
    @DisplayName("로또번호가 당첨번호와 5개 일치하고 보너스 번호를 가지고 있다면 2등을 반한한다.")
    @Test
    void returnSecondRankWhenHitFiveAndBonus() {
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);

        Lotto myLotto = new Lotto(List.of(1,2,3,4,5,7));

        Assertions.assertThat(winningLotto.getRankOf(myLotto)).isEqualTo(Rank.SECOND);
    }
    @DisplayName("로또번호가 당첨번호와 5개 일치하고 보너스 번호를 포함하지않는다면 3등을 반한한다.")
    @Test
    void returnThirdRankWhenHitFive() {
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);

        Lotto myLotto = new Lotto(List.of(1,2,3,4,5,8));

        Assertions.assertThat(winningLotto.getRankOf(myLotto)).isEqualTo(Rank.THIRD);
    }
    @DisplayName("로또번호가 당첨번호와 4개 일치하면 4등을 반한한다.")
    @Test
    void returnFourthRankWhenHitFour() {
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);

        Lotto myLotto = new Lotto(List.of(1,2,3,4,8,9));

        Assertions.assertThat(winningLotto.getRankOf(myLotto)).isEqualTo(Rank.FOURTH);
    }
    @DisplayName("로또번호가 당첨번호와 3개 일치하면 5등을 반한한다.")
    @Test
    void returnFifthRankWhenHitThree() {
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);

        Lotto myLotto = new Lotto(List.of(1,2,3,8,9,10));

        Assertions.assertThat(winningLotto.getRankOf(myLotto)).isEqualTo(Rank.FIFTH);
    }
    @DisplayName("로또번호가 당첨번호와 2개보다 적게 일치하면 등수가 없다.")
    @Test
    void returnNoRankWhenHitLowerThanTwo() {
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);

        Lotto myLotto = new Lotto(List.of(1,2,8,9,10,11));

        Assertions.assertThat(winningLotto.getRankOf(myLotto)).isEqualTo(Rank.NOTHING);
    }
}