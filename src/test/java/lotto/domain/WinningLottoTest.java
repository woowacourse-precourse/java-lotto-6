package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class WinningLottoTest {

    @Test
    void 당첨_로또_문자열_변환_테스트() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");

        assertThat(winningLotto.getLotto().getNumbers().size()).isEqualTo(6);
    }

    @Test
    void 당첨_보너스_문자열_변환_테스트() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");

        assertThat(winningLotto.getBonus()).isEqualTo(7);
    }

    @Test
    void 당첨_로또_랭킹_일치_테스트() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        RankingLotto rankingLotto = winningLotto.matchLotto(lotto);

        assertThat(rankingLotto.getMessage()).isEqualTo("6개 일치");


    }

}