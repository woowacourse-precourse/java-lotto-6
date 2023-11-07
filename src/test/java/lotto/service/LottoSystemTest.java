package lotto.service;

import lotto.model.Lotto;
import lotto.model.Player;
import lotto.type.WinningResultType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoSystemTest {

    @DisplayName("해당 로또가 당첨번호와 몇개 일치하는지 카운트한다.")
    @Test
    void checkMatchCount() {
        //given
        LottoSystem lottoSystem = new LottoSystem(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        //when
        int lottoCount = lottoSystem.checkMatchCount(lotto);
        //then
        assertThat(lottoCount).isEqualTo(3);
    }

    @DisplayName("해당 로또가 당첨번호와 몇개 일치하는지 카운트하고 이에 해당하는 WinningResultTpye를 반환한다.")
    @Test
    void checkWinning1() {
        //given
        LottoSystem lottoSystem = new LottoSystem(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        //when
        WinningResultType winningResultType = lottoSystem.checkWinning(lotto);
        //then
        assertThat(winningResultType).isEqualTo(WinningResultType.WINNING_RESULT_3_MATCH);
    }

    @DisplayName("해당 로또가 당첨번호와 몇개 일치하는지 카운트하고 이에 해당하는 WinningResultTpye를 반환한다. - 5개일치,보너스일치 확인")
    @Test
    void checkWinning2() {
        //given
        LottoSystem lottoSystem = new LottoSystem(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        //when
        WinningResultType winningResultType = lottoSystem.checkWinning(lotto);
        //then
        assertThat(winningResultType).isEqualTo(WinningResultType.WINNING_RESULT_5_MATCH_AND_BONUS_MATCH);
    }

    @DisplayName("보너스번호가 일치하는지 확인한다.")
    @Test
    void checkMatchBonus() {
        //given
        LottoSystem lottoSystem = new LottoSystem(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        //when
        boolean isMatch = lottoSystem.checkMatchBonus(lotto);
        //then
        assertThat(isMatch).isTrue();
    }

    @DisplayName("랜덤 로또를 생성한다.")
    @Test
    void generateLotto() {
        //given & when
        Lotto lotto = LottoSystem.generateLotto();
        //then
        assertThat(lotto).isInstanceOf(Lotto.class);
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @DisplayName("당첨타입에 해당하는 금액을 플레이어에게 지급한다.")
    @Test
    void giveWinningAccountToPlayer() {
        //given
        LottoSystem lottoSystem = new LottoSystem(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        WinningResultType winningResultType = WinningResultType.WINNING_RESULT_6_MATCH;
        Player player = new Player();
        //when
        lottoSystem.giveWinningAccountToPlayer(winningResultType, player);
        //then
        assertThat(player.getTotalWinningAccount()).isEqualTo(winningResultType.getWinningPrice());
    }



}