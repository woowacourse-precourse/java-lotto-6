package lotto.lotto;

import lotto.game.WinningLottoCounter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @Test
    @DisplayName("당첨 번호와 발행된 로또 비교하여 일치하는 개수 파악하는 테스트")
    void numberMatchingTest() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(List.of(lotto));
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 8;
        WinningLottoCounter winningLottoCounter = new WinningLottoCounter();

        //when
        lottos.calculateMatchesOfNumber(bonusNumber, winningNumber, winningLottoCounter);

        //then
        assertThat(winningLottoCounter.getCount(5)).isEqualTo(1);
    }

    @Test
    @DisplayName("일치하는 개수가 5개일 때 보너스 번호 일치 여부 확인하는 테스트")
    void bonusNumberMatchingTest() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(List.of(lotto));
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 6;
        WinningLottoCounter winningLottoCounter = new WinningLottoCounter();

        //when
        lottos.calculateMatchesOfNumber(bonusNumber, winningNumber, winningLottoCounter);

        //then
        assertThat(winningLottoCounter.getCount(5)).isEqualTo(0);
        assertThat(winningLottoCounter.getCount(0)).isEqualTo(1);
    }
}