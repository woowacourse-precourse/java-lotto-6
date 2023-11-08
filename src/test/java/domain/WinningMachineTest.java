package domain;

import constant.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningMachineTest {

    Lotto winningNumber = new Lotto(List.of(1,2,3,4,5,6));
    BonusNumber bonusNumber = new BonusNumber(7);
    WinningMachine winningMachine= new WinningMachine(winningNumber, bonusNumber);

    @DisplayName("6개 일치하면 1등 랭크를 생성한다.")
    @Test
    void getWinningRank_FIRST() {
        Rank actual =  winningMachine.getWinningRank(new Lotto(List.of(1,2,3,4,5,6)));
        assertThat(actual).isEqualTo(Rank.FIRST);
    }

    @DisplayName("5개가 일치, 보너스 번호가 맞으면 2등 랭크를 생성한다.")
    @Test
    void getWinningRank_SECOND() {
        Rank actual =  winningMachine.getWinningRank(new Lotto(List.of(1,2,3,4,5,7)));
        assertThat(actual).isEqualTo(Rank.SECOND);
    }

    @DisplayName("5개가 일치, 보너스 번호가 틀리면 3등 랭크를 생성한다.")
    @Test
    void getWinningRank_THIRD() {
        Rank actual =  winningMachine.getWinningRank(new Lotto(List.of(1,2,3,4,5,44)));
        assertThat(actual).isEqualTo(Rank.THIRD);
    }

    @DisplayName("4개가 일치하면 4등 랭크를 생성한다.")
    @Test
    void getWinningRank_FOURTH() {
        Rank actual =  winningMachine.getWinningRank(new Lotto(List.of(1,2,3,4,10,44)));
        assertThat(actual).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("3개가 일치하면 5등 랭크를 생성한다.")
    @Test
    void getWinningRank_FIFTH() {
        Rank actual =  winningMachine.getWinningRank(new Lotto(List.of(1,2,3,9,10,44)));
        assertThat(actual).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("2개가 일치하면 NONE 랭크를 생성한다.")
    @Test
    void getWinningRank_NONE() {
        Rank actual =  winningMachine.getWinningRank(new Lotto(List.of(1,2,8,9,10,44)));
        assertThat(actual).isEqualTo(Rank.NONE);
    }
}